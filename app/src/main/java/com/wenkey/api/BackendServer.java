package com.wenkey.api;

import com.wenkey.sections.Home.VotingFragment.model.profile.FetchProfileResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ali Assadi on 10/21/2017.
 */

public interface BackendServer {

    @GET("profiles/")
        Call<FetchProfileResponse> fetchProfiles();
}
