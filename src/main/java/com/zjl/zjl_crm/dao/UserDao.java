package com.zjl.zjl_crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zjl.zjl_base.BaseDao;
import com.zjl.zjl_crm.model.User;

public interface UserDao extends BaseDao<User>{

	public List<User> listAll();
	
	/**
	 * 获取登录账号
	 * @param userName 用户名
	 * @param password 密码
	 * @param roleName 角色名称
	 * @return
	 */
	public User findUserByUserNamePwdRole(@Param(value="userName")String userName, 
			@Param(value="password")String password, 
			@Param(value="roleName")String roleName);
	
	/**
	 * 通过userID获取用户信息
	 * @param userId
	 * @return
	 */
	public User loadById(Integer userId);
	
	/**
	 * 更新密码
	 * @param userId
	 * @param password
	 * @return
	 */
	public int updatePassword(@Param(value="userId")Integer userId,
			@Param(value="password")String password);

	public List<User> findByRoleName(@Param(value="roleName")String roleName);
	
}
