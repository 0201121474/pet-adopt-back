package com.pet.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.pet.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    IPage<Blog> selectMyBlog(IPage<Blog> page);
    IPage<Blog> queryBlogPage(IPage<Blog> page, @Param(Constants.WRAPPER) Wrapper<Blog> queryWrapper);
    List<Blog> queryAllBlog();
    Blog queryBlogById(Long id);
    List<Blog> queryBlogByUserId(Long userid);
    Integer updateBlog(Blog blog);
    Integer saveBlog(Blog blog);
}
