package com.ocloudwork.spring.demo.myservice;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.ocloudwork.spring.demo.bo.URoleBo;
import com.ocloudwork.spring.demo.bo.UserRoleAllocationBo;
import com.ocloudwork.spring.demo.model.UUser;
import com.ocloudwork.spring.demo.mybatis.page.Pagination;


public interface UUserService {

	int deleteByPrimaryKey(Long id);

	UUser insert(UUser record);

    UUser insertSelective(UUser record);

    UUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUser record);

    int updateByPrimaryKey(UUser record);
    
    UUser login(String email ,String pswd);

	UUser findUserByEmail(String email);

	Pagination<UUser> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);

	Map<String, Object> deleteUserById(String ids);

	Map<String, Object> updateForbidUserById(Long id, Long status);

	Pagination<UserRoleAllocationBo> findUserAndRole(ModelMap modelMap,
			Integer pageNo, Integer pageSize);

	List<URoleBo> selectRoleByUserId(Long id);

	Map<String, Object> addRole2User(Long userId, String ids);

	Map<String, Object> deleteRoleByUserIds(String userIds);
}
