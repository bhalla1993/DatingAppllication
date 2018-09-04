package com.wenkey.sections.Home.VotingFragment.view;

import java.util.List;

import com.wenkey.sections.Home.VotingFragment.model.user.UserProfile;

/**
 * Created by Ali Assadi on 10/21/2017.
 */
public interface VotingFragmentView {

    void showLoading();

    void hideLoading();

    void showProfiles(List<UserProfile> profiles);

    void showNegativeVote();

    void showPositiveVote();

    void showMatch(UserProfile profile);

    int cardsLeft();

    void showOutOfVotes();
}
