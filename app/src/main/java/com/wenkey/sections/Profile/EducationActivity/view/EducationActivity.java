package com.wenkey.sections.Profile.EducationActivity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.wenkey.R;
import com.wenkey.base.BaseActivity;
import com.wenkey.sections.Profile.EducationActivity.presenter.EducationActivityPresenter;

/**
 * Created by Ali Assadi on 10/20/2017.
 */

public class EducationActivity extends BaseActivity<EducationActivityPresenter> implements EducationActivityView {
    @NonNull
    @Override
    protected EducationActivityPresenter createPresenter(@NonNull Context context) {
        return new EducationActivityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
    }
}
