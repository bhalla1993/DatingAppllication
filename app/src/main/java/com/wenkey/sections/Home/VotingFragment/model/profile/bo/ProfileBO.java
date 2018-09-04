package com.wenkey.sections.Home.VotingFragment.model.profile.bo;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

import java.util.List;

import com.wenkey.sections.Home.VotingFragment.model.user.UserProfile;
import com.wenkey.sections.Home.VotingFragment.model.profile.dao.ProfileDAO;
import com.wenkey.sections.Home.VotingFragment.model.VoteResponse;

/**
 * Created by Ali Assadi on 10/21/2017.
 */
public class ProfileBO {

    private final ProfileDAO mDao;

    public ProfileBO(@NonNull final ProfileDAO dao) {
        mDao = dao;
    }

    public List<UserProfile> fetchProfiles() {
        return mDao.fetchProfiles();
    }

    @WorkerThread
    public VoteResponse profileVoted(final UserProfile profile, final boolean vote) {
        final int remainingVotes = mDao.fetchRemainingVotes();
        if (remainingVotes == 0){
            return new VoteResponse(false, true);
        } else {
            final boolean isAMatch = mDao.voteProfile(profile, vote);
            return new VoteResponse(isAMatch, false);
        }

    }
}
