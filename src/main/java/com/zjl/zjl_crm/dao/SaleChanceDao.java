package com.zjl.zjl_crm.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zjl.zjl_crm.model.SaleChance;
import com.zjl.zjl_crm.query.SaleChanceQuery;

public interface SaleChanceDao {
	
	/**
	 * 分页查询
	 * @param query
	 * @param pageBounds
	 * @return
	 */
	public List<SaleChance> selectForPage(SaleChanceQuery query, PageBounds pageBounds);

}
