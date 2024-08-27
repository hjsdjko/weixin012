package com.cl.dao;

import com.cl.entity.ShicaifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShicaifenleiView;


/**
 * 食材分类
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
public interface ShicaifenleiDao extends BaseMapper<ShicaifenleiEntity> {
	
	List<ShicaifenleiView> selectListView(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);

	List<ShicaifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
	
	ShicaifenleiView selectView(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
	

}
