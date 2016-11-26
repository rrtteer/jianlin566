package com.zjl.zjl_crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjl.zjl_base.ResultInfo;
import com.zjl.zjl_crm.constant.Constant;
import com.zjl.zjl_crm.model.User;
import com.zjl.zjl_crm.service.UserService;
import com.zjl.zjl_crm.util.LoginUserUtil;
import com.zjl.zjl_crm.vo.UserLoginIdentity;



@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public String listAll(Model model) {
		List<User> users = userService.listAll();
		model.addAttribute("users", users);
		return "user_list";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ResultInfo login(String userName, String password, String roleName) {
		/*try {
			UserLoginIdentity result = userService.login(userName, password, roleName);
			return new ResultInfo(result);
		} catch (ParamException e) {
			return new ResultInfo(Constant.RESULT_ERROR, e.getMessage());
		}*/
		UserLoginIdentity result = userService.login(userName, password, roleName);
		return new ResultInfo(result);
		
	}
	
	@RequestMapping(value = "update_password")
	@ResponseBody
	public ResultInfo updatePassword(String oldPassword, String newPassword, 
			String confirmPassword, HttpServletRequest request) {
		/*try {
			Integer userId = LoginUserUtil.loadUserIdFromCookie(request);
			userService.updatePassword(oldPassword, newPassword, 
					confirmPassword, userId);
			return new ResultInfo(Constant.OPT_SUCCESS);
		} catch (ParamException e) {
			return new ResultInfo(Constant.RESULT_ERROR, e.getMessage());
		}*/
		Integer userId = LoginUserUtil.loadUserIdFromCookie(request);
		userService.updatePassword(oldPassword, newPassword, 
				confirmPassword, userId);
		return new ResultInfo(Constant.OPT_SUCCESS);
		
	}
	@RequestMapping("find_customer_manager")
	@ResponseBody
	public List<User> findCustomerManager(){
		List<User> customerManagers=userService.findCustomerManager();
		return customerManagers;
	}
	
}
