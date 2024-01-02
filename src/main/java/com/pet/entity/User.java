package com.pet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String avatar;
    private int sex;
    private String telephone;
    private String email;
    private String username;
    private String password;
    private List<Blog> blogs;
    private List<PetBlog> petBlogs;

}
