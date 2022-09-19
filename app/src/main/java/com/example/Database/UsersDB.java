package com.example.Database;

import com.example.testmvvm.Domain.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDB {

    private static int id = 0;
    private static final User[] users = {
        new User("John", "Smith"),
        new User("Matt", "Daemon"),
        new User("Chris", "Hamsword"),
        new User("Angelina", "Joly"),
        new User("Scarlett", "Johanson"),
        new User("Selena", "Gomez"),
        new User("Dead", "Inside")
    };

    public static User[] getUsers() {
        return users;
    }

    public static List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        for (User user:users
             ) {
            userList.add(user);
        }
        return userList;
    }
}
