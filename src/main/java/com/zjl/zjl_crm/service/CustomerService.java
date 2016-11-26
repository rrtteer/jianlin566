package com.zjl.zjl_crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjl.zjl_crm.dao.CustomerDao;
import com.zjl.zjl_crm.vo.CustomerVo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	public List<CustomerVo> findAll() {
		List<CustomerVo> customerVos=customerDao.listAll();
		return customerVos;
	}
	

}
