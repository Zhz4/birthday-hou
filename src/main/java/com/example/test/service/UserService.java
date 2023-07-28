package com.example.test.service;

import com.example.test.requestJson.Format;

public interface UserService {
    Format getUserById(int id);

    Format getAllUser();

    Format addUser(String username, String password);

    Format updateUser(String username, String password,int id);

    Format deleteUser(int id);
}
