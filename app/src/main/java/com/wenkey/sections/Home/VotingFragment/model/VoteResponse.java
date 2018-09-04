package com.wenkey.sections.Home.VotingFragment.model;

/**
 * Created by Renaro Santos on 25/05/17.
 */

public class VoteResponse {

    private final boolean isMatch;
    private final boolean isOutOfVotes;

    public VoteResponse(final boolean isMatch, final boolean isOutOfVotes) {
        this.isMatch = isMatch;
        this.isOutOfVotes = isOutOfVotes;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public boolean isOutOfVotes() {
        return isOutOfVotes;
    }
}
