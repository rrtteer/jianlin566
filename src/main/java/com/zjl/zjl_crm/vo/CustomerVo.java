package com.zjl.zjl_crm.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerVo implements Serializable {
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
