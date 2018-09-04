package com.wenkey.sections.Home.VotingFragment.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.List;

import com.wenkey.R;
import com.wenkey.sections.Home.VotingFragment.model.user.UserProfile;
import com.wenkey.base.BaseFragment;
import com.wenkey.sections.Home.VotingFragment.model.profile.bo.ProfileBO;
import com.wenkey.sections.Home.VotingFragment.model.profile.dao.AppProfileDAO;
import com.wenkey.sections.Home.VotingFragment.model.AppTaskExecutor.AppTaskExecutor;
import com.wenkey.sections.Home.VotingFragment.presenter.VotingPresenter;

public class VotingFragment extends BaseFragment<VotingPresenter>
        implements VotingFragmentView, ProfileAdapter.ProfileListener {

    private View loading;
    private SwipeFlingAdapterView mSwipeList;
    private ProfileAdapter mAdapter;
    private MatchDialog mMatchDialog;

    @NonNull
    @Override
    protected VotingPresenter createPresenter(@NonNull final Context context) {
        return new VotingPresenter(this, new AppTaskExecutor(getActivity()), new ProfileBO(new AppProfileDAO()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mGeneralView = LayoutInflater.from(getActivity()).inflate(R.layout.activity_voting,null);

        final View heartIcon = mGeneralView.findViewById(R.id.heart_icon);
        final View brokenHeartIcon = mGeneralView.findViewById(R.id.broken_hear_icon);

        loading = mGeneralView.findViewById(R.id.loading);
        mSwipeList = (SwipeFlingAdapterView) mGeneralView.findViewById(R.id.swipe_list);
        mSwipeList.setFlingListener(new SwipeListener());
        OnVoteButtonsClicked onVoteButtonsClicked = new OnVoteButtonsClicked();
        heartIcon.setOnClickListener(onVoteButtonsClicked);
        brokenHeartIcon.setOnClickListener(onVoteButtonsClicked);

        return mGeneralView;
    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showProfiles(final List<UserProfile> profiles) {
        UserProfile[] array = new UserProfile[profiles.size()];
        mAdapter = new ProfileAdapter(getActivity(), R.layout.profile_card, profiles.toArray(array));
        mAdapter.setListener(this);
        mSwipeList.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNegativeVote() {
        try {
            mSwipeList.getTopCardListener().selectLeft();
        } catch (Exception e) {e.printStackTrace();}
    }


    @Override
    public void showPositiveVote() {
        mSwipeList.getTopCardListener().selectRight();
    }

    @Override
    public void showMatch(final UserProfile profile) {
        mMatchDialog = new MatchDialog(getActivity());
        mMatchDialog.setProfile(profile);
        mMatchDialog.show();
    }

    @Override
    public int cardsLeft() {
        return mSwipeList.getChildCount();
    }

    @Override
    public void showOutOfVotes() {
        Toast.makeText(getActivity(), "Out of Votes! Wait", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProfileRemoved(@NonNull final UserProfile profile) {
        mPresenter.onProfileRemoved(profile);
    }

    @Override
    public void onEmptyList() {
        mPresenter.onEmptyList();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mMatchDialog != null) {
            mMatchDialog.dismiss();
        }
    }

    private class SwipeListener implements SwipeFlingAdapterView.onFlingListener {
        @Override
        public void removeFirstObjectInAdapter() {
            mAdapter.removeTop();
        }

        @Override
        public void onLeftCardExit(final Object o) {
            mPresenter.onSlideProfileToLeft();
        }

        @Override
        public void onRightCardExit(final Object o) {
            mPresenter.onSlideProfileToRight();
        }

        @Override
        public void onAdapterAboutToEmpty(final int i) {
        }

        @Override
        public void onScroll(final float v) {
        }
    }

    private class OnVoteButtonsClicked implements View.OnClickListener {
        @Override
        public void onClick(final View view) {
            switch (view.getId()) {
                case R.id.heart_icon:
                    mPresenter.onPositiveButtonClicked();
                    break;
                case R.id.broken_hear_icon:
                    mPresenter.onNegativeButtonClicked();
                    break;
            }
        }
    }
}
