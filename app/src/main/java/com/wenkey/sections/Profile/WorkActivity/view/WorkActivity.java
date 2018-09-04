package com.wenkey.sections.Profile.WorkActivity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.wenkey.R;
import com.wenkey.base.BaseActivity;
import com.wenkey.sections.Profile.WorkActivity.presenter.WorkActivityPresenter;

/**
 * Created by Ali Assadi on 10/20/2017.
 */

public class WorkActivity extends BaseActivity<WorkActivityPresenter> implements WorkActivityView {
    @NonNull
    @Override
    protected WorkActivityPresenter createPresenter(@NonNull Context context) {
        return new WorkActivityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
    }
}
