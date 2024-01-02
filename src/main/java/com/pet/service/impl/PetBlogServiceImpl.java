package com.pet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pet.dao.PetBlogMapper;
import com.pet.entity.PetBlog;
import com.pet.service.PetBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *@Description:
 */

@Slf4j
@Service
public class PetBlogServiceImpl implements PetBlogService {

    @Autowired
    PetBlogMapper petBlogMapper;

    @Override
    public List<PetBlog> queryAllPetBlogs() {
        List<PetBlog> petBlogs = petBlogMapper.queryAll();
        for (PetBlog blog : petBlogs) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//定义新的日期格式
            blog.setDateTime(formatter.format(blog.getTime()));
        }
        return petBlogs;
    }

    @Override
    public IPage<PetBlog> queryPetBlogsByPage(Integer pageNo, Integer pageSize) {
        Page<PetBlog> page = new Page<>(pageNo, pageSize);
        IPage<PetBlog> mapIPage = petBlogMapper.selectMyPetBlog(page);
        List<PetBlog> records = mapIPage.getRecords();
        for (PetBlog record : records) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            record.setDateTime(formatter.format(record.getTime()));
        }
        return mapIPage;
    }

    @Override
    public IPage<PetBlog> queryBlogsByUserId(Integer pageNo, Integer pageSize, Long userId) {
        QueryWrapper<PetBlog> wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        Page<PetBlog> page = new Page<>(pageNo, pageSize);
        IPage<PetBlog> blogIPage = petBlogMapper.queryBlogPage(page, wrapper);
        List<PetBlog> records = blogIPage.getRecords();
        for (PetBlog record : records) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            record.setDateTime(formatter.format(record.getTime()));
        }
        return blogIPage;
    }

    @Override
    public PetBlog queryPetBlogById(Long petBlogId) {
        PetBlog petBlog = petBlogMapper.queryById(petBlogId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//定义新的日期格式
        petBlog.setDateTime(formatter.format(petBlog.getTime()));
        return petBlog;
    }

    @Transactional
    @Override
    public String addPetBlog(PetBlog petBlog) {
        Date date = new Date();
        java.sql.Date dateNow = new java.sql.Date(date.getTime());
        petBlog.setTime(dateNow);
        int i = petBlogMapper.insertPetBlog(petBlog);
        if (i > 0) {
            return "success";
        } else {
            log.debug("宠物博客插入失败");
            return "error";
        }
    }

    @Transactional
    @Override
    public String updatePetBlog(PetBlog petBlog) {
        int res = petBlogMapper.updatePetBlog(petBlog);
        if(res <= 0) {
            return "error";
        }
        return "success";
    }

    @Transactional
    @Override
    public String deletePetBlog(Long petBlogId) {
        int res = petBlogMapper.deleteById(petBlogId);
        if(res < 0) {
            return "error";
        }
        return "success";
    }

}
