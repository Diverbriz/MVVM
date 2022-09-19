package com.example.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.testmvvm.viewModels.TickViewModel;

public class TickFactory extends ViewModelProvider.AndroidViewModelFactory {
    private String str;
    private Application application;
    public TickFactory(Application application, String str){
        super(application);
        this.application = application;
        this.str = str;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TickViewModel(application, str);
    }
}
