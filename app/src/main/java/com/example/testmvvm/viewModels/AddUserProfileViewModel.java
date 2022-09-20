package com.example.testmvvm.viewModels;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testmvvm.DI.ServiceLocator;
import com.example.testmvvm.Domain.Model.User;
import com.example.testmvvm.Domain.Model.UserProfile;
import com.example.testmvvm.Domain.Operations.UserProfileOperations;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddUserProfileViewModel extends ViewModel {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addUserProfile(String name,
                               String address,
                               String description,
                               List<String> images){

        UserProfile userProfile = UserProfileOperations.addUserProfile(
                name,
                new User("Владимир", "Шелоумов"),
                address,
                description,
                images.stream().filter(Objects::nonNull).collect(Collectors.toList())
        );

        ServiceLocator.getInstance().getRepository().addUserProfile(userProfile);
    }


}
