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
public class Blog {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String title;
    private String address;
    private String introduce;
    private String images;
    private String petname;
    private int petsex;
    private int petage;
    private int varieties;
    private int free;
    private int petadopt;
    private Date time;
    private String datetime;
    private Long userId;
    private User user;
}
