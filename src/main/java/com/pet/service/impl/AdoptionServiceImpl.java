package com.pet.service.impl;
import com.pet.dao.AdoptionMapper;
import com.pet.dao.BlogMapper;
import com.pet.entity.Adoption;
import com.pet.entity.Blog;
import com.pet.entity.User;
import com.pet.service.AdoptionService;
import com.pet.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@Description:
 */

@Slf4j      // 日志
@Service    // 加入spring容器
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    AdoptionMapper adoptionMapper;

    @Autowired
    BlogMapper blogMapper;

    @Transactional
    @Override
    public String addAdoption(Adoption adoption) {
        adoption.setState(0); // 未处理
        int res = adoptionMapper.insert(adoption);
        if (res > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @Transactional
    @Override
    public String deleteAdoption(Long adoptionId) {
        int res = adoptionMapper.deleteById(adoptionId);
        if (res > 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @Transactional
    @Override
    public String updateAdoption(Adoption adoption) {
        int res = adoptionMapper.updateById(adoption);
        if(res <= 0){
            return "error";
        }
        return "success";
    }

    @Override
    public String acceptAdoption(Long adoptionId) {
        // 修改blog、adoption
        Adoption adoption = adoptionMapper.queryAdoptionById(adoptionId);
        adoption.setState(1); // 已接受
        int adoption_res = adoptionMapper.updateAdoption(adoption);
        if(adoption_res <= 0) {
            return "error";
        }
        Long blogId = adoption.getBlogId();
        Blog blog = blogMapper.queryBlogById(blogId);
        blog.setPetadopt(1); // 已接受
        int blog_res = blogMapper.updateBlog(blog);
        if(blog_res <= 0) {
            return "error";
        }
        return "success";
    }

    @Override
    public String refuseAdoption(Long adoptionId) {
        // 修改adoption
        Adoption adoption = adoptionMapper.queryAdoptionById(adoptionId);
        adoption.setState(2); // 已拒绝
        int res = adoptionMapper.updateAdoption(adoption);
        if(res <= 0) {
            return "error";
        }
        return "success";
    }

    @Override
    public List<Adoption> queryAdoptions(Long userId) {
        List<Adoption> adoptions = adoptionMapper.queryAdoptionByUserId(userId);
        return adoptions;
    }

}
