package com.pet.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.pet.entity.Blog;
import com.pet.entity.PetBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PetBlogMapper extends BaseMapper<PetBlog> {
    IPage<PetBlog> selectMyPetBlog(IPage<PetBlog> page);
    List<PetBlog> queryAll();
    IPage<PetBlog> queryBlogPage(IPage<PetBlog> page, @Param(Constants.WRAPPER) Wrapper<PetBlog> queryWrapper);
    PetBlog queryById(Long id);
    int updatePetBlog(PetBlog petBlog);
    int insertPetBlog(PetBlog petBlog);
}
