package com.wenkey.sections.Profile.AccountFragment.presenter;

import com.wenkey.sections.Profile.AccountFragment.view.AccountFragmentView;
import com.wenkey.base.BasePresenter;

/**
 * Created by Ali Assadi on 10/16/2017.
 */

public class AccountFragmentPresenter extends BasePresenter {

    private final AccountFragmentView mView;

    public AccountFragmentPresenter(AccountFragmentView view) {
        this.mView = view;
    }

    public void onSettingClicked() {
        mView.goToSetting();
    }

    public void onEditInfoClicked() {
        mView.goToEditInfo();
    }
}
