package com.pet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetBlog {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String introduce; //介绍
    private String images;
    private Long userId;
    private String title;
    private Date time;
    private String dateTime;

    private User user;
}
