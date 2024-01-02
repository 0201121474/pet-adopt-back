package com.pet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pet.dao.BlogMapper;
import com.pet.entity.Blog;
import com.pet.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Blog> queryAllBlogs() {
        List<Blog> blogs = blogMapper.queryAllBlog();
        for (Blog blog : blogs) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//定义新的日期格式
            blog.setDatetime(formatter.format(blog.getTime()));
        }
        return blogs;
    }

    @Override
    public IPage<Blog> queryBlogsByPage(Integer pageNo, Integer pageSize) {
        Page<Blog> page = new Page<>(pageNo, pageSize);
        IPage<Blog> mapIPage = blogMapper.selectMyBlog(page);
        List<Blog> records = mapIPage.getRecords();
        for (Blog record : records) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            record.setDatetime(formatter.format(record.getTime()));
        }
        return mapIPage;
    }

    @Override
    public IPage<Blog> queryBlogsByUserId(Integer pageNo, Integer pageSize, Long userId) {
        QueryWrapper<Blog> wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        Page<Blog> page = new Page<>(pageNo, pageSize);
        IPage<Blog> blogIPage = blogMapper.queryBlogPage(page, wrapper);
        List<Blog> records = blogIPage.getRecords();
        for (Blog record : records) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            record.setDatetime(formatter.format(record.getTime()));
        }
        return blogIPage;
    }

    @Override
    public Blog queryBlogById(Long blogId) {
        Blog blog = blogMapper.queryBlogById(blogId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//定义新的日期格式
        blog.setDatetime(formatter.format(blog.getTime()));
        return blog;
    }

    @Transactional
    @Override
    public String addBlog(Blog blog) {
        String title = blog.getTitle();
        if(StringUtils.isEmpty(title)){
            return "error";
        }
        // 设置博客发表时间
        Date date = new Date();
        java.sql.Date dateNow = new java.sql.Date(date.getTime());
        blog.setTime(dateNow);
        int insert = blogMapper.saveBlog(blog);
        if (insert > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @Transactional
    @Override
    public String updateBlog(Blog blog) {
        // 判断: userId == blog.user_id

        Integer i = blogMapper.updateBlog(blog);
        if (i > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @Transactional
    @Override
    public String deleteBlog(Long blogId) {
        // 判断: userId == blog.user_id
        int i = blogMapper.deleteById(blogId);
        if (i > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @Transactional
    @Override
    public String setPetAdopt(Long blogId) {
        Blog blog = blogMapper.queryBlogById(blogId);
        blog.setPetadopt(1);
        Integer integer = blogMapper.updateBlog(blog);
        if (integer > 0) {
            return "success";
        } else {
            return "error";
        }
    }

}
