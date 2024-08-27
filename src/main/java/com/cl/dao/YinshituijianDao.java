package com.cl.dao;

import com.cl.entity.YinshituijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshituijianView;


/**
 * 饮食推荐
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:21:13
 */
public interface YinshituijianDao extends BaseMapper<YinshituijianEntity> {
	
	List<YinshituijianView> selectListView(@Param("ew") Wrapper<YinshituijianEntity> wrapper);

	List<YinshituijianView> selectListView(Pagination page,@Param("ew") Wrapper<YinshituijianEntity> wrapper);
	
	YinshituijianView selectView(@Param("ew") Wrapper<YinshituijianEntity> wrapper);
	

}
