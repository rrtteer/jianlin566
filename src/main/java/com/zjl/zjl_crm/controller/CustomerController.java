package com.zjl.zjl_crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjl.zjl_crm.service.CustomerService;
import com.zjl.zjl_crm.vo.CustomerVo;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("find_all")
	@ResponseBody
	private List<CustomerVo> findAll(){
		return customerService.findAll();
	}
}
