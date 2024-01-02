package com.pet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pet.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    Long queryUser(String username);
    List<User> queryAllById(Long id);
    User queryUserById(Long id);
    User queryUserByUserName(String username);
    List<User> queryAllByUserName(String username);
    int updateUserById(User user);
    Integer saveUser(User user);
}
