package com.wenkey.sections.Profile.AccountFragment.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenkey.R;
import com.wenkey.sections.Profile.AccountFragment.presenter.AccountFragmentPresenter;
import com.wenkey.base.BaseFragment;
import com.wenkey.sections.Profile.EditInfoActivity.view.EditInfoActivity;
import com.wenkey.sections.Profile.SettingActivity.view.SettingActivity;

/**
 * Created by Ali Assadi on 10/16/2017.
 */

public class AccountFragment  extends BaseFragment<AccountFragmentPresenter> implements  AccountFragmentView, View.OnClickListener {

    private View mGeneralView;

    @NonNull
    @Override
    protected AccountFragmentPresenter createPresenter(@NonNull Context context) {
        return new AccountFragmentPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mGeneralView = inflater.inflate(R.layout.fragment_account, null);
        mGeneralView.findViewById(R.id.setting).setOnClickListener(this);
        mGeneralView.findViewById(R.id.edit_info).setOnClickListener(this);

        return mGeneralView;
    }

  /*  @OnClick(R.id.setting)
     void onSettingClicked() {
        mPresenter.onSettingClicked();
    }

    @OnClick(R.id.edit_info)
     void onEditInfoClicked() {
        mPresenter.onEditInfoClicked();
    }*/

    @Override
    public void goToSetting() {
        startActivity(new Intent(getActivity(),SettingActivity.class));
    }

    @Override
    public void goToEditInfo() {
        startActivity(new Intent(getActivity(),EditInfoActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                mPresenter.onSettingClicked();
                break;
            case R.id.edit_info:
                mPresenter.onEditInfoClicked();
                break;
        }
    }
}
