package com.example.Database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testmvvm.Domain.Model.UserProfile;
import com.example.testmvvm.repository.Model.UserProfileDTO;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void addUser(UserProfileDTO user);

    @Delete
    void deleteUser(UserProfileDTO userProfileDTO);


    @Query("SELECT * FROM user_profile")
    LiveData<List<UserProfileDTO>> getAllUserProfile();

//    @Query("SELECT * FROM user")
//    List<UserProfile> getAll();
//
//    @Query("SELECT * FROM user WHERE id = :id")
//    UserProfile getById(long id);
//
//    @Insert
//    void insert(UserProfile... user);
//
//    @Update
//    void update(UserProfile user);
//
//    @Query("SELECT * FROM ")
//    LiveData<List<UserProfile>> getAllUsers();


}
