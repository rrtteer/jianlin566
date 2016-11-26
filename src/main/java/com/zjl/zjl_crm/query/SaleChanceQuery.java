package com.zjl.zjl_crm.query;

import java.io.Serializable;

import com.zjl.zjl_base.BaseQuery;

@SuppressWarnings("serial")
public class SaleChanceQuery extends BaseQuery {
	
	private String customerName;
	private String overview;
	private String createMan;
	private Integer state; // 分配状态 为null就是查询所有
	

	private Integer devResult; 
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public Integer getDevResult() {
		return devResult;
	}
	public void setDevResult(Integer devResult) {
		this.devResult = devResult;
	}
}
