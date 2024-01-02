package com.pet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pet.entity.Adoption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdoptionMapper extends BaseMapper<Adoption> {
    int insertAdoption(Adoption adoption);
    List<Adoption> queryAdoptionByUserId(Long userId);
    Adoption queryAdoptionById(Long adoptionId);
    int updateAdoption(Adoption adoption);
}
