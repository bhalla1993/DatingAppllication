package com.wenkey.sections.Home.MainActivity.presenter;

import android.support.design.widget.TabLayout;

import com.wenkey.base.BasePresenter;
import com.wenkey.sections.Home.MainActivity.view.MainActivity;

/**
 * Created by Ali Assadi on 10/15/2017.
 */

public class MainActivityPresenter extends BasePresenter {
    private final MainActivity mView;

    public MainActivityPresenter(MainActivity view) {
        mView = view;
    }

    public void onTabSelected(TabLayout.Tab tab) {
        mView.selectTab(tab);
    }

    public void onTabUnSelected(TabLayout.Tab tab) {
        mView.unSelectTab(tab);

    }
}
