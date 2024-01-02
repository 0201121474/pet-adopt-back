package com.pet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pet.entity.Blog;
import com.pet.entity.PetBlog;

import java.util.List;

/**
 * @Description:
 */
public interface PetBlogService {

    /**
     * @description: 查询所有宠物博客
     * @param:
     * @return: java.util.List<com.pet.entity.PetBlog>
     **/
    public List<PetBlog> queryAllPetBlogs();

    /**
     * @description: 查询宠物博客: 分页查询
     * @param: current
     * @param: size
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<java.lang.String>
     **/
    public IPage<PetBlog> queryPetBlogsByPage(Integer pageNo, Integer pageSize);

    /**
     * @description: 查询用户博客
     * @param: current
     * @param: size
     * @param: userid
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.pet.entity.Blog>
     **/
    public IPage<PetBlog> queryBlogsByUserId(Integer pageNo, Integer pageSize, Long userId);


    /**
     * @description: 查询宠物博客: 通过博客id
     * @param: petBlogsId
     * @return: com.pet.entity.PetBlog
     **/
    public PetBlog queryPetBlogById(Long petBlogId);

    /**
     * @description: 添加宠物博客
     * @param: petBlog
     * @return: java.lang.String
     **/
    public String addPetBlog(PetBlog petBlog);

    /**
     * @description: 更新宠物博客
     * @param: userId 用户id
     * @param: petBlog 宠物博客信息
     * @return: java.lang.String
     **/
    public String updatePetBlog(PetBlog petBlog);

    /**
     * @description: 删除宠物博客
     * @param: userId 用户id
     * @param: petBlogId 需要删除的宠物博客id
     * @return: java.lang.String
     **/
    public String deletePetBlog(Long petBlogId);

}
