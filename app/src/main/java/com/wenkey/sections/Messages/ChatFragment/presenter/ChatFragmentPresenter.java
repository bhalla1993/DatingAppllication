package com.wenkey.sections.Messages.ChatFragment.presenter;

import com.wenkey.base.BasePresenter;
import com.wenkey.sections.Messages.ChatFragment.view.ChatFragmentView;

/**
 * Created by Ali Assadi on 10/16/2017.
 */

public class ChatFragmentPresenter extends BasePresenter {

    private final ChatFragmentView mView;

    public ChatFragmentPresenter(ChatFragmentView view) {
        this.mView = view;
    }
}
