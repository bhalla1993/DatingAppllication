package com.wenkey.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ali Assadi on 7/26/2017.
 */

public class Prefs {
    private static Prefs mInstance;
    private SharedPreferences mPrefs;

    public Prefs() {
        mPrefs = App.getInstance().getSharedPreferences(Keys.SP_MAIN, Context.MODE_PRIVATE);
    }

    public synchronized static Prefs getInstance() {
        if (mInstance == null) {
            mInstance = new Prefs();
        }
        return mInstance;
    }

    public boolean contains(String key) {
        return mPrefs.contains(key);
    }

    public void putBoolean(String key, boolean value) {
        mPrefs.edit().putBoolean(key, value).apply();
    }

    public void putString(String key, String value) {
        mPrefs.edit().putString(key, value).apply();
    }

    public String getStringOrEmpty(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defValue) {
        return mPrefs.getString(key, defValue);
    }

    public int getInt(String key) {
        return getInt(key, 0);
    }

    public int getInt(String key, int defValue) {
        return mPrefs.getInt(key, defValue);
    }

    public void putInt(String key, int value) {
        mPrefs.edit().putInt(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mPrefs.getBoolean(key, defValue);
    }

    public long getLong(String key) {
        return getLong(key, 0);
    }

    public long getLong(String key, long defValue) {
        return mPrefs.getLong(key, defValue);
    }

    public void putLong(String key, long value) {
        mPrefs.edit().putLong(key, value).apply();
    }
}
