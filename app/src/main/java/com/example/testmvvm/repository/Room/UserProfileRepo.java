package com.example.testmvvm.repository.Room;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.Database.UserDatabase;
import com.example.Database.dao.UserDao;
import com.example.testmvvm.Domain.Model.UserProfile;
import com.example.testmvvm.repository.Model.UserProfileDTO;
import com.example.testmvvm.repository.RepositoryTask;

import java.util.List;

public class UserProfileRepo implements RepositoryTask {

    private UserDao mUserDao;
    private LiveData<List<UserProfileDTO>> mAllUserProfile;

    public UserProfileRepo(Application application) {
        UserDatabase db = UserDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mAllUserProfile = mUserDao.getAllUserProfile();
    }

    public LiveData<List<UserProfileDTO>> getAllUserProfile() {
        return mAllUserProfile;
    }


    @Override
    public void addUserProfile(UserProfile userProfile) {
        UserProfileDTO dto = UserProfileDTO.convertFromProfile(userProfile);

        UserDatabase.databaseWriterExecutor.execute(() -> {
            mUserDao.addUser(dto);
        });
    }

    @Override
    public void deleteUserProfile(UserProfile userProfile) {
        UserProfileDTO dto = UserProfileDTO.convertFromProfile(userProfile);

        UserDatabase.databaseWriterExecutor.execute(() -> {
            mUserDao.addUser(dto);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  MutableLiveData<UserProfileDTO>
        findUserProfile(String id, LifecycleOwner owner) {
        MutableLiveData<UserProfileDTO> specificUserProfile =
                new MutableLiveData<>();


        mAllUserProfile.observe(owner, (List<UserProfileDTO> parties) -> {
            specificUserProfile.setValue(parties.stream()
                    .filter(userProfileDTO -> id.equals(userProfileDTO.getId()))
                    .findAny()
                    .orElse(null)
            );
        });
        return specificUserProfile;
    }
}
