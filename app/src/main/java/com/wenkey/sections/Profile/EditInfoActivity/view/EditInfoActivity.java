package com.wenkey.sections.Profile.EditInfoActivity.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import butterknife.ButterKnife;
import butterknife.OnClick;
import com.wenkey.R;
import com.wenkey.base.BaseActivity;
import com.wenkey.sections.Profile.EditInfoActivity.presenter.EditInfoActivityPresenter;
import com.wenkey.sections.Profile.EducationActivity.view.EducationActivity;
import com.wenkey.sections.Profile.WorkActivity.view.WorkActivity;

/**
 * Created by Ali Assadi on 10/17/2017.
 */

public class EditInfoActivity extends BaseActivity<EditInfoActivityPresenter> implements EditInfoActivityView {

    @NonNull
    @Override
    protected EditInfoActivityPresenter createPresenter(@NonNull Context context) {
        return new EditInfoActivityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);
        ButterKnife.bind(this);
        initActionBar("Edit Info", true);
    }

    @OnClick(R.id.current_work)
    void onCurrentWorkClicked() {
        mPresenter.onCurrentWorkClicked();
    }

    @OnClick(R.id.education)
    void onEducationClicked() {
        mPresenter.onEducationClicked();
    }

    @Override
    public void startWorkActivity() {
        startActivity(new Intent(this, WorkActivity.class));
    }

    @Override
    public void startEducationActivity() {
        startActivity(new Intent(this, EducationActivity.class));
    }
}
