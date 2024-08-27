package com.cl.dao;

import com.cl.entity.YinshijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshijiluView;


/**
 * 饮食记录
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
public interface YinshijiluDao extends BaseMapper<YinshijiluEntity> {
	
	List<YinshijiluView> selectListView(@Param("ew") Wrapper<YinshijiluEntity> wrapper);

	List<YinshijiluView> selectListView(Pagination page,@Param("ew") Wrapper<YinshijiluEntity> wrapper);
	
	YinshijiluView selectView(@Param("ew") Wrapper<YinshijiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<YinshijiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinshijiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YinshijiluEntity> wrapper);



}
