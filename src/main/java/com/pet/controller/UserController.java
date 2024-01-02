package com.pet.controller;

import com.pet.dao.UserMapper;
import com.pet.entity.User;
import com.pet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class UserController {
    
    @Autowired
    UserService userService;


    @GetMapping("/login/{username}/{password}")
    public int userLogin(@PathVariable("username") String username,
                         @PathVariable("password") String password) {
        int res = userService.userLogin(username, password);
        return res;
    }

    @GetMapping("/user/select/{userName}")
    public User userSelectByUserName(@PathVariable("userName") String userName) {
        User user = userService.queryUserByUserName(userName);
        return user;
    }

    @GetMapping("/user/selectBlog/{userName}")
    public List<User> userSelectBlogByUserName(@PathVariable("userName") String userName) {
        List<User> users = userService.queryBlogsByUserName(userName);
        return users;
    }

    @GetMapping("/user/selectById/{id}")
    public User queryUserById(@PathVariable("id") Long id) {
        User user = userService.queryUserById(id);
        return user;
    }

    @PostMapping("/user/update")
    public String userUpdate(@RequestBody User user) {
        String res = userService.updateUser(user);
        return res;
    }

    @PostMapping("/user/save")
    public String saveUser(@RequestBody User user) {
        String res = userService.addUser(user);
        return res;
    }

}

