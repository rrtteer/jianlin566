package com.zjl.zjl_crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zjl.zjl_base.BaseDao;
import com.zjl.zjl_crm.model.Customer;
import com.zjl.zjl_crm.vo.CustomerVo;

public interface CustomerDao extends BaseDao<Customer>{
	
	@Select("select id,name from t_customer where isValid=1 and state=0")
	public List<CustomerVo> listAll();

}
