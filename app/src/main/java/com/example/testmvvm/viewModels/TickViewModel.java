package com.example.testmvvm.viewModels;

import android.app.Application;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testmvvm.Domain.Model.User;

import java.util.List;

public class TickViewModel extends AndroidViewModel {
    private MutableLiveData<String> liveData;
    private LiveData<List<User>> listUser;
    private String toastText;


    public TickViewModel(@NonNull Application application, String toastText) {
        super(application);
        this.toastText = toastText;
        startTimer();
    }

//    public LiveData<List<User>> getListUser() {
//        return listUser;
//    }

    @NonNull
    @Override
    public <T extends Application> T getApplication() {
        return super.getApplication();
    }

    public MutableLiveData<List<User>> getListUser(){
        if(listUser == null)
            listUser = new MutableLiveData<>();
        return (MutableLiveData<List<User>>) listUser;
    }

    public MutableLiveData<String> getLiveData(){
        if(liveData == null){
            liveData = new MutableLiveData<String>();
        }
        return liveData;
    }

    public void startTimer(){
        new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                liveData.setValue(Long.toString(l/1000));
//                txt.setText(Long.toString(l/1000));
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplication(), toastText, Toast.LENGTH_LONG).show();
            }
        }.start();
    }
}
