package com.wenkey.sections.Profile.SettingActivity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.wenkey.R;
import com.wenkey.base.BaseActivity;
import com.wenkey.sections.Profile.SettingActivity.presenter.SettingActivityPresenter;

/**
 * Created by Ali Assadi on 10/17/2017.
 */

public class SettingActivity extends BaseActivity<SettingActivityPresenter> {

    @NonNull
    @Override
    protected SettingActivityPresenter createPresenter(@NonNull Context context) {
        return new SettingActivityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initActionBar("Setting",true);
    }
}
