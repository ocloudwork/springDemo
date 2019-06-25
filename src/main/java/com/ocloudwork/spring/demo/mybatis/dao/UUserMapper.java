package com.ocloudwork.spring.demo.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.ocloudwork.spring.demo.bo.URoleBo;
import com.ocloudwork.spring.demo.model.UUser;

public interface UUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UUser record);

    int insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);

	UUser login(Map<String, Object> map);

	UUser findUserByEmail(String email);

	List<URoleBo> selectRoleByUserId(Long id);

}