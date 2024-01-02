package com.pet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adoption {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String telephone;
    private String wechatId;
    private String email;
    private String qqId;
    private String blogtitle;
    private String content;
    private int state;
    private Long blogId;
    private Long userId;
    private User user;


}
