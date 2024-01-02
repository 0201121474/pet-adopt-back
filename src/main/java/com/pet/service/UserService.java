package com.pet.service;

import com.pet.entity.User;

import java.util.List;

/**
 * @Description:
 */

public interface UserService {

    /**
     * @description: 查询用户信息: 根据用户名
     * @param: userName
     * @return: com.pet.entity.User
     **/
    public User queryUserByUserName(String userName);

    /**
     * @description: 查询用户博客: 根据用户名
     * @param: userName 用户名
     * @return: java.util.List<com.pet.entity.User>
     **/
    public List<User> queryBlogsByUserName(String userName);

    /**
     * @description: 查询用户信息: 根据用户id
     * @param: id
     * @return: com.pet.entity.User
     **/
    public User queryUserById(Long userId);

    /**
     * @description: 用户登录
     * @param: username 用户名
     * @param: password 密码
     * @return: int
     **/
    public int userLogin(String username, String password);

    /**
     * @description: 用户注册
     * @param: user 用户信息
     * @return: String
     **/
    public String addUser(User user);

    /**
     * @description: 更新用户信息
     * @param: user 用户信息
     * @return: java.lang.String
     **/
    public String updateUser(User user);

    /**
     * @description: 删除账号
     * @param: userId 用户id
     * @return: java.lang.String
     **/
    public String deleteUser(Long userId);


}
