package com.zjl.zjl_base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface BaseDao<T> {
	
	 /**
     * 新增
     * @return
     */
	public int insert(T entity);
	
	/**
	 * 修改
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除
	 * @return
	 */
	public int delete (int id);

    /**
     * 批量删除
     * @param ids 多个已逗号分隔
     * @return
     */
    public int deleteBatch(@Param("ids") String ids);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T loadById(int id);

    /**
     * 分页查询
     * @param pageBounds
     * @return
     */
    public List<T> selectForPage(BaseQuery query, PageBounds pageBounds);

    /**
     * 根据查询条件获取结果
     * @param param
     */
    public List<T> find(Map<String, Object> param);
    
	
}
