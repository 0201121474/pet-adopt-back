package com.pet.service.impl;

import com.pet.dao.UserMapper;
import com.pet.entity.User;
import com.pet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByUserName(String userName) {
        User user = userMapper.queryUserByUserName(userName);
        return user;
    }

    @Override
    public List<User> queryBlogsByUserName(String userName) {
        List<User> users = userMapper.queryAllByUserName(userName);
        return users;
    }

    @Override
    public User queryUserById(Long userId) {
        User user = userMapper.queryUserById(userId);
        return user;
    }

    @Override
    public int userLogin(String username, String password) {
        Long userId = userMapper.queryUser(username);
        if(userId == null) {
            return 404;//用户错误
        }
        User user = userMapper.queryUserById(userId);
        String pwd = user.getPassword();
        if (!password.equals(pwd)) {
            return 405;//密码错误
        }
        // 成功
        return 200;
    }

    @Transactional
    @Override
    public String addUser(User user) {
        /*try {
            userMapper.saveUser(user);
            return "success";
        } catch (Exception e) {
            return "error";
        }*/
        String userName = user.getUsername();
        User userTemp = userMapper.queryUserByUserName(userName);
        if(userTemp != null) {
            log.debug("用户名已经存在注册失败, username:{}", userName);
            return "error";
        }

        int insert = userMapper.saveUser(user);
        if(insert <= 0) {
            log.debug("注册用户失败");
            return "error";
        }
        return "success";
    }

    @Transactional
    @Override
    public String updateUser(User user) {
        int i = userMapper.updateUserById(user);
        if (i > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @Transactional
    @Override
    public String deleteUser(Long userId) {
        int res = userMapper.deleteById(userId);
        if(res < 0) {
            return "error";
        } else {
            return "success";
        }
    }

}
