package com.wenkey.sections.Messages.ChatFragment.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenkey.R;
import com.wenkey.base.BaseFragment;
import com.wenkey.sections.Messages.ChatFragment.presenter.ChatFragmentPresenter;
import com.wenkey.sections.Messages.MessageActivity.view.MessageActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ali Assadi on 10/17/2017.
 */

public class ChatFragment extends BaseFragment<ChatFragmentPresenter> implements ChatFragmentView {

    private View mGeneralView;

    @NonNull
    @Override
    protected ChatFragmentPresenter createPresenter(@NonNull Context context) {
        return new ChatFragmentPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mGeneralView = inflater.inflate(R.layout.fragment_chat, null);
        ButterKnife.bind(this, mGeneralView);
        return mGeneralView;
    }

    @OnClick(R.id.chats_container)
    void onChatClick() {
        startActivity(new Intent(getActivity(), MessageActivity.class));
    }

}
