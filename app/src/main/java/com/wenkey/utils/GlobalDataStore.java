package com.wenkey.utils;

import com.google.gson.Gson;
import com.wenkey.sections.Home.VotingFragment.model.user.User;

/**
 * Created by Ali Assadi on 10/24/2017.
 */

public class GlobalDataStore {

    public User getUser() {
        Gson gson = new Gson();
        String userJson = Prefs.getInstance().getString(Keys.SP_USER, "");
        User user = gson.fromJson(userJson, User.class);
        return user;
    }
}
