package com.wenkey.sections.Messages.MessageActivity.presenter;

import com.wenkey.base.BasePresenter;
import com.wenkey.sections.Messages.MessageActivity.view.MessageActivity;

/**
 * Created by Ali Assadi on 10/18/2017.
 */

public class MessageActivityPresenter extends BasePresenter {
    private final MessageActivity mView;

    public MessageActivityPresenter(MessageActivity view) {
        mView = view;
    }
}
