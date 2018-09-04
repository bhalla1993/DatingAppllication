package com.wenkey.sections.Messages.MessageActivity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.wenkey.R;
import com.wenkey.base.BaseActivity;
import com.wenkey.sections.Messages.MessageActivity.presenter.MessageActivityPresenter;

/**
 * Created by Ali Assadi on 10/18/2017.
 */

public class MessageActivity extends BaseActivity<MessageActivityPresenter> {
    @NonNull
    @Override
    protected MessageActivityPresenter createPresenter(@NonNull Context context) {
        return new MessageActivityPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getSupportActionBar().hide();
    }
}
