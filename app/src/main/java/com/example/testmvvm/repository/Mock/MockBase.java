package com.example.testmvvm.repository.Mock;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testmvvm.Domain.Model.User;
import com.example.testmvvm.Domain.Model.UserProfile;
import com.example.testmvvm.repository.Model.UserProfileDTO;
import com.example.testmvvm.repository.RepositoryTask;

import java.util.ArrayList;
import java.util.List;

public class MockBase implements RepositoryTask {
    MutableLiveData<List<UserProfile>> data;
    List<UserProfile> list;

    public  MutableLiveData<List<UserProfile>>  getAllUserProfile() {
        return data;
    }

    public MockBase(){
        list = new ArrayList<>();

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setCreator(new User("Vladimir", "Sheloumov"));
        userProfile1.setName("Profile 1");
        userProfile1.setAddress("Moscow");
        list.add(userProfile1);

        UserProfile userProfile2 = new UserProfile();
        userProfile1.setCreator(new User("Vladimir", "Sheloumov"));
        userProfile1.setName("Profile 2");
        userProfile1.setAddress("Moscow");
        list.add(userProfile2);

        UserProfile userProfile3 = new UserProfile();
        userProfile1.setCreator(new User("Vladimir", "Sheloumov"));
        userProfile1.setName("Profile 3");
        userProfile1.setAddress("Moscow");
        list.add(userProfile3);

        UserProfile userProfile4 = new UserProfile();
        userProfile1.setCreator(new User("Vladimir", "Sheloumov"));
        userProfile1.setName("Profile 4");
        userProfile1.setAddress("Moscow");
        list.add(userProfile4);

        UserProfile userProfile5 = new UserProfile();
        userProfile1.setCreator(new User("Vladimir", "Sheloumov"));
        userProfile1.setName("Profile 5");
        userProfile1.setAddress("Moscow");
        list.add(userProfile5);

        data.setValue(list);
    }

    @Override
    public void addUserProfile(UserProfile userProfile) {
        list.add(userProfile);

        data.setValue(list);
    }

    @Override
    public void deleteUserProfile(UserProfile userProfile) {
        list.remove(userProfile);

        data.setValue(list);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public MutableLiveData<UserProfile> findUserProfile(String id, LifecycleOwner owner) {
        MutableLiveData<UserProfile> specificParty = new MutableLiveData<>();

        data.observe(owner, (List<UserProfile> parties) -> {
            specificParty.setValue(parties.stream()
                    .filter(party -> id.equals(party.getId()))
                    .findAny()
                    .orElse(null)
            );
        });

        return specificParty;
    }
}
