package com.wenkey.sections.Home.VotingFragment.model.profile;

import android.support.annotation.NonNull;

import com.wenkey.sections.Home.VotingFragment.model.user.UserProfile;

import java.util.ArrayList;

/**
 * Created by Ali Assadi on 10/21/2017.
 */
public class FetchProfileResponse {

    final ArrayList<RemoteProfile> profiles;

    public FetchProfileResponse(final ArrayList<RemoteProfile> profiles) {
        this.profiles = profiles;
    }

    @NonNull
    public ArrayList<UserProfile> getProfiles() {
        return convertRemoteToLocalProfiles(profiles);
    }

    @NonNull
    private ArrayList<UserProfile> convertRemoteToLocalProfiles(final ArrayList<RemoteProfile> profiles) {
        if (profiles != null) {
            final ArrayList<UserProfile> result = new ArrayList<>(profiles.size());
            for (final RemoteProfile profile : profiles) {
                result.add(UserProfile.from(profile));
            }
            return result;
        } else {
            return new ArrayList<>();
        }
    }
}
