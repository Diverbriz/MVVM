package com.example.testmvvm.repository;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testmvvm.Domain.Model.UserProfile;
import com.example.testmvvm.repository.Model.UserProfileDTO;

import java.util.List;

public interface RepositoryTask {
    <T extends UserProfile> LiveData<List<UserProfileDTO>> getAllUserProfile();
    void addUserProfile(UserProfile userProfile);
    void deleteUserProfile(UserProfile userProfile);
    <T extends UserProfile> MutableLiveData<T> findUserProfile(String id, LifecycleOwner owner);
}