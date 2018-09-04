package com.wenkey.sections.Home.VotingFragment.model.user;

import com.wenkey.sections.Home.VotingFragment.model.profile.RemoteProfile;

/**
 * Created by Ali Assadi on 10/21/2017.
 */
public class UserProfile {

    public static final int DEFAULT_AGE = 18;
    private final int id;
    private final String imageUrl;
    private final String name;
    private final int age;

    public UserProfile(final int id, final String imageUrl, final String name, final int age) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static UserProfile from(final RemoteProfile profile) {
        int age = getAge(profile.age);
        return new UserProfile(profile.id, profile.cover, profile.name, age);
    }

    private static int getAge(final String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return DEFAULT_AGE;
        }
    }

    public int getId() {
        return id;
    }
}
