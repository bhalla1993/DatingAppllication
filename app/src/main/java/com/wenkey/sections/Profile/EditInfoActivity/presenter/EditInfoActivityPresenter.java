package com.wenkey.sections.Profile.EditInfoActivity.presenter;

import com.wenkey.base.BasePresenter;
import com.wenkey.sections.Profile.EditInfoActivity.view.EditInfoActivity;

/**
 * Created by Ali Assadi on 10/17/2017.
 */

public class EditInfoActivityPresenter extends BasePresenter {

    private final EditInfoActivity mView;

    public EditInfoActivityPresenter(EditInfoActivity view) {
        mView = view;
    }

    public void onCurrentWorkClicked() {
        mView.startWorkActivity();
    }

    public void onEducationClicked() {
        mView.startEducationActivity();
    }
}