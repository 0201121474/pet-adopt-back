package com.pet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pet.entity.Blog;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Description:
 */
public interface BlogService {


    /**
     * @description: 查询博客
     * @param:
     * @return: java.util.List<com.pet.entity.Blog>
     **/
    public List<Blog> queryAllBlogs();

    /**
     * @description: 查询博客
     * @param: current
     * @param: size
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.pet.entity.Blog>
     **/
    public IPage<Blog> queryBlogsByPage(Integer pageNo, Integer pageSize);

    /**
     * @description: 查询用户博客
     * @param: current
     * @param: size
     * @param: userid
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.pet.entity.Blog>
     **/
    public IPage<Blog> queryBlogsByUserId(Integer pageNo, Integer pageSize, Long userId);

    /**
     * @description: 查询博客: 根据博客id
     * @param: blogId
     * @return: com.pet.entity.Blog
     **/
    public Blog queryBlogById(Long blogId);

    /**
     * @description: 增加博客
     * @param: blog
     * @return: java.lang.String
     **/
    public String addBlog(Blog blog);

    /**
     * @description: 更新博客
     * @param: blog
     * @return: java.lang.String
     **/
    public String updateBlog(Blog blog);

    /**
     * @description: 删除博客: 根据博客id
     * @param: blogId
     * @return: java.lang.String
     **/
    public String deleteBlog(Long blogId);

    /**
     * @description: 领养宠物
     * @param: blogId
     * @return: java.lang.String
     **/
    public String setPetAdopt(Long blogId);

}
