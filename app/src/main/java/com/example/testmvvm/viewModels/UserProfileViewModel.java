package com.example.testmvvm.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.testmvvm.Domain.Model.UserProfile;

public class UserProfileViewModel extends ViewModel {
    private UserProfile userProfile;

    public UserProfile getUserProfile(){
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile){
        this.userProfile = userProfile;
    }
}
