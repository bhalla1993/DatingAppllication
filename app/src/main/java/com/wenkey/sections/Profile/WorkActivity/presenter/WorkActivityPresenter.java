package com.wenkey.sections.Profile.WorkActivity.presenter;

import com.wenkey.base.BasePresenter;
import com.wenkey.sections.Profile.WorkActivity.view.WorkActivityView;

/**
 * Created by Ali Assadi on 10/20/2017.
 */

public class WorkActivityPresenter extends BasePresenter {
    private final WorkActivityView mView;

    public WorkActivityPresenter(WorkActivityView view) {
        mView = view;
    }
}
