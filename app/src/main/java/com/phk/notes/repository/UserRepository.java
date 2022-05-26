package com.phk.notes.repository;

import com.phk.notes.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private static List<User> users;

    static {
        users = new ArrayList<>(Arrays.asList(
                new User("pedro", "123"),
                new User("admin", "123")));
    }

    public static void insertUser(User user) {users.add(user);}

    public static User getUser(String login) {
        for(User user : users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public static User getUser(String login, String password) {

        for(User user : users) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) return user;
        }
        return null;
    }
}
