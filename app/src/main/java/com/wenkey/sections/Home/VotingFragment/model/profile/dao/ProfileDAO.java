package com.wenkey.sections.Home.VotingFragment.model.profile.dao;

import java.util.List;

import com.wenkey.sections.Home.VotingFragment.model.user.UserProfile;

/**
 * Created by Ali Assadi on 10/21/2017.
 */
public abstract class ProfileDAO {

    public abstract List<UserProfile> fetchProfiles();

    public abstract int fetchRemainingVotes();

    public abstract boolean voteProfile(final UserProfile profile, final boolean vote);
}
