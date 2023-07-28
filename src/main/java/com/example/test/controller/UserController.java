package com.example.test.controller;

import com.example.test.requestJson.Format;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    //将Service注入Web层
    @Autowired
    private UserService userService;

    /**
     * 根据id查用户
     *
     * @param id 用户id
     * @return 返回用户细腻
     */
    @RequestMapping(value = "/getuserByid", method = RequestMethod.GET)
    @ResponseBody
    public Format login(@RequestParam("id") int id) {
        return userService.getUserById(id);
    }

    /**
     * 获取所有用户信息
     * @return 所有用户信息
     */
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public Format getAlluser() {
        return userService.getAllUser();
    }

    /**
     * 增加用户
     * @param username 用户名
     * @param password 密码
     * @return 成功与否
     */
    @PostMapping("/adduser")
    @ResponseBody
    public Format addUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.addUser(username,password);
    }

    /**
     * 修该用户
     * @param username 用户名
     * @param password 密码
     * @param id 用户id
     * @return 成功与否
     */
    @PutMapping("/updateuser")
    @ResponseBody
    public Format updateUser(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("id") int id) {
        return userService.updateUser(username,password,id);
    }

    @DeleteMapping("/deleteuser")
    @ResponseBody
    public Format deleteUser(@RequestParam("id") int id){
        return userService.deleteUser(id);
    }

}
