package com.wenkey.sections.Home.MainActivity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.wenkey.R;
import com.wenkey.base.BaseActivity;
import com.wenkey.sections.Home.MainActivity.presenter.MainActivityPresenter;
import com.wenkey.utils.Tools;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ali Assadi on 10/15/2017.
 */

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityView{

     @BindView(R.id.tab_layout) TabLayout mTabLayout;
     @BindView(R.id.view_pager) ViewPager mViewPager;
    private OnTabSelected onTabSelectedListener;
    private MainActivityAdapter mAdapter;

    //color
    private final float white_transparent = 0.4f;
    private final float white = 1f;

    @NonNull
    @Override
    protected MainActivityPresenter createPresenter(@NonNull Context context) {
        return new MainActivityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        onTabSelectedListener = new OnTabSelected();

        mAdapter = new MainActivityAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);


        mTabLayout.addOnTabSelectedListener(onTabSelectedListener);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setCustomView(Tools.createTabIcon(this,R.drawable.tab_account));
        //mTabLayout.getTabAt(1).setCustomView(Tools.createTabIcon(this,R.drawable.tab_account));
        mTabLayout.getTabAt(2).setCustomView(Tools.createTabIcon(this,R.drawable.tab_message));

        mViewPager.setCurrentItem(1);


    }

    @Override
    public void selectTab(TabLayout.Tab tab) {
        //teb selected color
        tab.getCustomView().findViewById(R.id.icon).setAlpha(white);

    }

    @Override
    public void unSelectTab(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.icon).setAlpha(white_transparent);
    }


    private class OnTabSelected implements TabLayout.OnTabSelectedListener {


        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            try {
                mPresenter.onTabSelected(tab);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            try {
                mPresenter.onTabUnSelected(tab);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTabLayout.removeOnTabSelectedListener(onTabSelectedListener);
    }
}
