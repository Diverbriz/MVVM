package com.example.testmvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.room.Room;

import com.example.Database.UserDatabase;
import com.example.testmvvm.databinding.ActivityMainBinding;
import com.example.testmvvm.viewModels.TickViewModel;
import com.example.view.fragments.bottom_nav.HomeFragment;
import com.example.view.fragments.bottom_nav.ProfileFragment;
import com.example.view.fragments.bottom_nav.SettingFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TickViewModel model;
    ActivityMainBinding binding;

    NavController navController;
    UserDatabase userDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userDatabase = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "user-database").build();

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.action_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.action_profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.action_settings:
                    replaceFragment(new SettingFragment());
                    break;
            }

            return  true;
        });

//        userList = UsersDB.getAllUsers();

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        List<User> everyone = userDatabase.userDao().getAll();
//        System.out.println("All person" + everyone);
    }
}