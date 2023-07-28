package com.example.test.serviceImpl;

import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.requestJson.Format;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public Format getUserById(int id) {
        UserBean userBean = userMapper.userbyId(id);
        System.out.println(userBean);
        Format format = new Format();
        format.setCode(0);
        format.setMsg("success");
        format.setData(userBean);
        return format;
    }

    @Override
    public Format getAllUser() {
        List<UserBean> alluserBean = userMapper.getAllUser();
        Format format = new Format();
        format.setCode(0);
        format.setMsg("success");
        format.setData(alluserBean);
        return format;
    }

    @Override
    public Format addUser(String username, String password) {
        int row = userMapper.addUser(username, password);
        Format format = new Format();
        if (row > 0){
            format.setCode(0);
            format.setMsg("success");
        }else {
            format.setCode(1);
            format.setMsg("fail");
        }
        return format;
    }

    @Override
    public Format updateUser(String username, String password,int id) {
        int row = userMapper.updateUser(username,password,id);
        Format format = new Format();
        if (row > 0){
            format.setCode(0);
            format.setMsg("success");
        }else {
            format.setCode(1);
            format.setMsg("fail");
        }
        return format;
    }

    @Override
    public Format deleteUser(int id) {
        int row = userMapper.deleteUser(id);
        Format format = new Format();
        if (row > 0){
            format.setCode(0);
            format.setMsg("success");
        }else {
            format.setCode(1);
            format.setMsg("fail");
        }
        return format;
    }

}
