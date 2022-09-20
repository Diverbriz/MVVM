package com.example.testmvvm.DI;

import android.app.Application;

import com.example.testmvvm.repository.Mock.MockBase;
import com.example.testmvvm.repository.RepositoryTask;
import com.example.testmvvm.repository.Room.UserProfileRepo;

public class ServiceLocator {
    private static ServiceLocator instance = null;

    private ServiceLocator(){}

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new ServiceLocator();
        }
        return instance;
    }

    private RepositoryTask mRepository;

    public void initBase(Application application){
        if(mRepository == null){
            mRepository = new UserProfileRepo(application);
        }
    }

    public RepositoryTask getRepository(){
        if(mRepository == null){
            mRepository = new MockBase();
        }
        return mRepository;
    }
}
