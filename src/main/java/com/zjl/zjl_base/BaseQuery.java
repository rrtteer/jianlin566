package com.zjl.zjl_base;

import java.io.Serializable;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@SuppressWarnings("serial")
public class BaseQuery implements Serializable {
	
	private Integer page; // 页码
	private Integer limit; // 查询记录数
	private String sort; // 排序字段
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public PageBounds initPageBounds() {
		if (limit == null || limit < 1) {
			limit = 10;
		}
		PageBounds pageBounds = new PageBounds(page, limit, Order.formString(sort));
		return pageBounds;
	}
}
