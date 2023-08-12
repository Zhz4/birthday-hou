package com.example.test.serviceImpl;

import com.example.test.bean.UserBean;
import com.example.test.enmu.Request;
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
        Request request = Request.SUCCESS;
        System.out.println(userBean);
        Format format = new Format();
        format.setCode(request.getCode());
        format.setMsg("success");
        format.setData(userBean);
        return format;
    }

    @Override
    public Format getAllUser() {
        List<UserBean> alluserBean = userMapper.getAllUser();
        Request request = Request.SUCCESS;
        Format format = new Format();
        format.setCode(request.getCode());
        format.setMsg("success");
        format.setData(alluserBean);
        return format;
    }

    private Format getFormat(int row) {
        Format format = new Format();
        if (row > 0) {
            Request request = Request.SUCCESS;
            format.setCode(request.getCode());
            format.setMsg("success");
        } else {
            Request request = Request.ERROR;
            format.setCode(request.getCode());
            format.setMsg("fail");
        }
        return format;
    }
    @Override
    public Format addUser(String username, String password) {
        int row = userMapper.addUser(username, password);
        return getFormat(row);
    }

    @Override
    public Format updateUser(String username, String password, int id) {
        int row = userMapper.updateUser(username, password, id);
        return getFormat(row);
    }

    @Override
    public Format deleteUser(int id) {
        int row = userMapper.deleteUser(id);
        Format format = new Format();
        if (row > 0) {
            format.setCode(0);
            format.setMsg("success");
        } else {
            format.setCode(1);
            format.setMsg("fail");
        }
        return format;
    }

    @Override
    public Format login(String username, String password) {
        UserBean userBean = userMapper.login(username, password);
        Format format = new Format();
        if (userBean != null) {
            Request request = Request.SUCCESS;
            format.setCode(request.getCode());
            format.setMsg("success");
        } else {
            Request request = Request.ERROR;
            format.setCode(request.getCode());
            format.setMsg("密码错误，请重新输入");
        }
        return format;
    }

}
