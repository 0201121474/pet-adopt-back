package com.pet.service;

import com.pet.entity.Adoption;

import java.util.List;

/**
 * @Description:
 */
public interface AdoptionService {

    /**
     * @description: 增加领养信息
     * @param: adoption 领养信息
     * @return: java.lang.String
     **/
    public String addAdoption(Adoption adoption);

    /**
     * @description: 删除领养信息
     * @param: adoptionId 领养id
     * @return: java.lang.String
     **/
    public String deleteAdoption(Long adoptionId);

    /**
     * @description: 修改领养信息
     * @param: adoption 领养信息
     * @return: java.lang.String
     **/
    public String updateAdoption(Adoption adoption);

    /**
     * @description: 拒绝收养
     * @param: adoptionId
     * @return: java.lang.String
     **/
    public String acceptAdoption(Long adoptionId);

    /**
     * @description: 拒绝收养
     * @param: adoptionId
     * @return: java.lang.String
     **/
    public String refuseAdoption(Long adoptionId);

    /**
     * @description: 查询领养信息
     * @param: userId 用户id
     * @return: java.util.List<com.pet.entity.Adoption>
     **/
    public List<Adoption> queryAdoptions(Long userId);


}
