package com.example.test.mapper;

import com.example.test.bean.UserBean;

import java.util.List;

public interface UserMapper {
    UserBean userbyId(int id);

    List<UserBean> getAllUser();

    int addUser(String username,String password);
    int updateUser(String username,String password,int id);

    int deleteUser(int id);

    UserBean login(String username,String password);
}
