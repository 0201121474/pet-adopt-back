package com.pet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pet.entity.Blog;
import com.pet.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blog/findAll")
    public List<Blog> selectAll() {
        List<Blog> blogs = blogService.queryAllBlogs();
        return blogs;
    }

    @GetMapping("/blog/findAll/{current}/{size}")
    public IPage<Blog> selectAll(@PathVariable("current") Integer current,
                                 @PathVariable("size") Integer size) {
        IPage<Blog> blogs = blogService.queryBlogsByPage(current, size);
        return blogs;
    }

    @GetMapping("/blog/findAll/{current}/{size}/{userid}")
    public IPage<Blog> selectAll(@PathVariable("current") Integer current,
                                 @PathVariable("size") Integer size,
                                 @PathVariable("userid") Long userid) {
        IPage<Blog> blogs = blogService.queryBlogsByUserId(current, size, userid);
        return blogs;
    }

    @GetMapping("/blog/find/{id}")
    public Blog selectBlog(@PathVariable("id") Long id) {
        Blog blog = blogService.queryBlogById(id);
        return blog;
    }

    @PostMapping("/blog/save")
    public String saveBlog(@RequestBody Blog blog) {
        String res = blogService.addBlog(blog);
        return res;
    }

    @PostMapping("/blog/update")
    public String updateBlog(@RequestBody Blog blog) {
        String res = blogService.updateBlog(blog);
        return res;
    }

    @DeleteMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id) {
        String res = blogService.deleteBlog(id);
        return res;
    }


}
