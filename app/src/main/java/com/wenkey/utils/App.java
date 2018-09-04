package com.wenkey.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.util.Locale;

/**
 * Created by Ali Assadi on 7/15/2017.
 */

public class App extends Application {
    private RefWatcher refWatcher;

    private static App mInstance;
    private static boolean mIsTablet;
    private static Point mScreen;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        //refWatcher = LeakCanary.install(this);
        // Normal app init code...

        mInstance = this;
       // mScreen = getScreenSize(this);



    }

    public void mustDie(Object object) {
        if (refWatcher != null)
            refWatcher.watch(object);
    }

    /*private String getDeviceMacAddress() {
        WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();
        return info.getMacAddress().replaceAll(":", "");
    }*/

    public static App getInstance() {
        return mInstance;
    }

    public void setLanguage() {
        Resources res = getResources();
        final DisplayMetrics dm = res.getDisplayMetrics();

        String languageToLoad = "iw";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList localeList = new LocaleList(locale);
            config.setLocales(localeList);
        } else {
            config.locale = locale;
        }

        res.updateConfiguration(config, dm);
    }

    public boolean isTablet() {
        return mIsTablet;
    }

    public boolean isPhone() {
        return !mIsTablet;
    }

    public boolean isTabletLargerThan1200() {
        if (mScreen == null) {
            getScreenSize(this);
        }


        final DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float screenWidthInDp = displayMetrics.widthPixels / displayMetrics.density;
        screenWidthInDp = screenWidthInDp - (1200 - screenWidthInDp);
        return screenWidthInDp >= 1200;
    }

    public Point getScreen() {
        return mScreen;
    }

    public Point getScreenSize(Context context) {
        if (mScreen == null || mScreen.x <= 0 || mScreen.y <= 0) {
            //Init Screen size
            mScreen = new Point(0, 0);

            DisplayMetrics dm = new DisplayMetrics();
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            wm.getDefaultDisplay().getMetrics(dm);
            mScreen.set(dm.widthPixels, dm.heightPixels);

            //Is Tablet
            double wi = (double) mScreen.x / dm.xdpi;
            double hi = (double) mScreen.y / dm.ydpi;
            double x = Math.pow(wi, 2);
            double y = Math.pow(hi, 2);
            double screenInches = Math.sqrt(x + y);

            mIsTablet = screenInches >= 7;
        }

        return mScreen;
    }


}

