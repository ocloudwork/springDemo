package com.ocloudwork.spring.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ocloudwork.spring.demo.bo.RolePermissionAllocationBo;
import com.ocloudwork.spring.demo.model.URole;
import com.ocloudwork.spring.demo.mybatis.page.Pagination;


public interface RoleService {

	int deleteByPrimaryKey(Long id);

    int insert(URole record);

    int insertSelective(URole record);

    URole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(URole record);

    int updateByPrimaryKey(URole record);

	Pagination<URole> findPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);

	Map<String, Object> deleteRoleById(String ids);

	Pagination<RolePermissionAllocationBo> findRoleAndPermissionPage(
			Map<String, Object> resultMap, Integer pageNo, Integer pageSize);
	//根据用户ID查询角色（role），放入到Authorization里。
	Set<String> findRoleByUserId(Long userId);

	List<URole> findNowAllPermission();
	//初始化数据
	void initData();
}
