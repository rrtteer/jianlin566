package com.zjl.zjl_crm.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjl.zjl_base.exception.LoginBizException;
import com.zjl.zjl_base.exception.ParamException;
import com.zjl.zjl_crm.constant.Constant;
import com.zjl.zjl_crm.dao.UserDao;
import com.zjl.zjl_crm.model.User;
import com.zjl.zjl_crm.util.AssertUtil;
import com.zjl.zjl_crm.util.MD5Util;
import com.zjl.zjl_crm.util.UserIDBase64;
import com.zjl.zjl_crm.vo.LoginUserInfo;
import com.zjl.zjl_crm.vo.UserLoginIdentity;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public List<User> listAll() {
		List<User> users = userDao.listAll();
		return users;
	}
	
	/**
	 * 用户登录
	 * @param userName 用户名
	 * @param password 密码
	 * @param roleName 角色名称
	 * @return 
	 */
	public UserLoginIdentity login(String userName, String password,
			String roleName) {
		
		// 基本参数验证
		/*if (StringUtils.isBlank(userName)) {
			throw new ParamException("请输入用户名");
		}
		if (StringUtils.isBlank(password)) {
			throw new ParamException("请输入密码");
		}
		if (StringUtils.isBlank(roleName)) {
			throw new ParamException("请选择用户类型");
		}*/
		AssertUtil.notEmpty(userName, "请输入用户名");
		AssertUtil.notEmpty(password, "请输入密码");
		AssertUtil.notEmpty(roleName, "请选择用户类型");
		// 用户是否存在
		password = MD5Util.md5Method(password); // md5加密
		User user = userDao.findUserByUserNamePwdRole(userName.trim(),
				password, roleName.trim());
		/*if (user == null) {
			throw new ParamException("用户名或密码错误.");
		}*/
		AssertUtil.notNull(user, "用户名或密码错误");
		
		// 封装返回对象
		UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
		userLoginIdentity.setUserIdString(UserIDBase64.encoderUserID(user.getId()));
		userLoginIdentity.setUserName(userName);
		return userLoginIdentity;
	}
	
	/**
	 * 获取登录用户的信息
	 * @param userId
	 * @return
	 * @throws LoginException 
	 */
	public LoginUserInfo findLoginUser(Integer userId) {
		
//		if (userId == null || userId < 1) {
//			throw new LoginBizException(Constant.LOGIN_FIRST);
//		}
//		User user = userDao.loadById(userId);
//		if (user == null) {
//			throw new LoginBizException(Constant.LOGIN_FIRST);
//		}
		User user = findUserById(userId);
		LoginUserInfo loginUserInfo = new LoginUserInfo();
		loginUserInfo.setRealName(user.getTrueName());
		loginUserInfo.setRoleName(user.getRoleName());
		loginUserInfo.setUserName(user.getUserName());
		return loginUserInfo;
	}
	
	/**
	 * 更改密码
	 * @param oldPassword 就密码
	 * @param newPassword 新密码
	 * @param confirmPassword 确认密码
	 */
	public void updatePassword(String oldPassword, String newPassword, 
			String confirmPassword, Integer userId) {
		
		// 基本参数校验
		checkUptPwdParams(oldPassword, newPassword, confirmPassword);
		
		// 通过用户ID获取用户信息
		User user = findUserById(userId);
		
		// 校验旧密码是否正确
		if (!MD5Util.md5Method(oldPassword).equals(user.getPassword())) {
			throw new ParamException("旧密码输入错误，请重新输入");
		}
		// 更新新密码
		int uptcount = userDao.updatePassword(userId, MD5Util.md5Method(newPassword));
		if (uptcount == 0) {
			throw new ParamException(Constant.OPT_FAILURE);
		}
	}
	
	/**
	 * 通过userId获取用户信息
	 * @param userId
	 * @return
	 */
	private User findUserById(Integer userId) {
		if (userId == null || userId < 1) {
			throw new LoginBizException(Constant.LOGIN_FIRST);
		}
		User user = userDao.loadById(userId);
		if (user == null) {
			throw new LoginBizException(Constant.LOGIN_FIRST);
		}
		return user;
	}
	
	/**
	 * 更新密码的参数验证
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 */
	private static void checkUptPwdParams(String oldPassword, 
			String newPassword, String confirmPassword) {
		AssertUtil.notEmpty(oldPassword, "请输入旧密码");
		AssertUtil.notEmpty(newPassword, "请输入新密码");
		AssertUtil.notEmpty(confirmPassword, "请输入确认密码");
		AssertUtil.isTrue(!confirmPassword.equals(newPassword), "确认密码不一致");
	}



	public List<User> findCustomerManager() {
		List<User> customerManagers=userDao.findByRoleName("客户经理");
		return customerManagers;
	}
	
}
