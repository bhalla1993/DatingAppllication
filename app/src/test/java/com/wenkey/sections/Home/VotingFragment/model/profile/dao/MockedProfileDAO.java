package com.wenkey.sections.Home.VotingFragment.model.profile.dao;

import java.util.ArrayList;
import java.util.List;

import com.wenkey.sections.Home.VotingFragment.model.user.UserProfile;

/**
 * Created by Ali Assadi on 10/21/2017.
 */

public class MockedProfileDAO extends ProfileDAO {
    @Override
    public List<UserProfile> fetchProfiles() {
        return new ArrayList<>();
    }

    @Override
    public int fetchRemainingVotes() {
        return 3;
    }

    @Override
    public boolean voteProfile(final UserProfile profile, final boolean vote) {
        return false;
    }
}
