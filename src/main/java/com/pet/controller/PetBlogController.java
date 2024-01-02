package com.pet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pet.dao.PetBlogMapper;
import com.pet.entity.Blog;
import com.pet.entity.PetBlog;
import com.pet.service.PetBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class PetBlogController {

    @Autowired
    PetBlogService petBlogService;

    @GetMapping("/petBlog/queryAll")
    public List<PetBlog> queryAll() {
        List<PetBlog> petBlogs = petBlogService.queryAllPetBlogs();
        return petBlogs;
    }

    @GetMapping("/petBlog/queryAll/{current}/{size}")
    public IPage<PetBlog> queryAll(@PathVariable("current") Integer current,
                                   @PathVariable("size") Integer size) {
        IPage<PetBlog> petBlogs = petBlogService.queryPetBlogsByPage(current, size);
        return petBlogs;
    }

    @GetMapping("/petBlog/queryAll/{current}/{size}/{userid}")
    public IPage<PetBlog> selectAll(@PathVariable("current") Integer current,
                                    @PathVariable("size") Integer size,
                                    @PathVariable("userid") Long userid) {
        IPage<PetBlog> blogs = petBlogService.queryBlogsByUserId(current, size, userid);
        return blogs;
    }

    @GetMapping("/petBlog/queryById/{id}")
    public PetBlog queryById(@PathVariable("id") Long id) {
        PetBlog petBlog = petBlogService.queryPetBlogById(id);
        return petBlog;
    }

    @PostMapping("/petBlog/insert")
    public String insertPetBlog(@RequestBody PetBlog petBlog) {
        String res = petBlogService.addPetBlog(petBlog);
        return res;
    }

    @PutMapping("/petBlog/update")
    public String updatePetBlog(@RequestBody PetBlog petBlog) {
        String res = petBlogService.updatePetBlog(petBlog);
        return res;
    }

    @DeleteMapping("/petBlog/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id) {
        String res = petBlogService.deletePetBlog(id);
        return res;
    }

}
