package com.cl.dao;

import com.cl.entity.ShicaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShicaixinxiView;


/**
 * 食材信息
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
public interface ShicaixinxiDao extends BaseMapper<ShicaixinxiEntity> {
	
	List<ShicaixinxiView> selectListView(@Param("ew") Wrapper<ShicaixinxiEntity> wrapper);

	List<ShicaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShicaixinxiEntity> wrapper);
	
	ShicaixinxiView selectView(@Param("ew") Wrapper<ShicaixinxiEntity> wrapper);
	

}
