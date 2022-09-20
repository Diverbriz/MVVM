package com.example.testmvvm.Domain.Operations;

import com.example.testmvvm.Domain.Model.User;
import com.example.testmvvm.Domain.Model.UserProfile;

import java.util.List;

public class UserProfileOperations {
    public static UserProfile addUserProfile(String name,
                                       User creator,
                                       String address,
                                       String description,
                                       List<String> images) {
        UserProfile profile = new UserProfile();
        profile.setName(name);
        if (creator != null) {
            profile.setCreator(creator);
        } else {
            profile.setCreator(new User("", "неизвестный"));
        }
        profile.setAddress(address);
        profile.setDescription(description);
        profile.setName(name);
        profile.setImages(images);

        return profile;
    }
}
