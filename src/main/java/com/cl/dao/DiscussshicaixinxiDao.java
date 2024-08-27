package com.cl.dao;

import com.cl.entity.DiscussshicaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshicaixinxiView;


/**
 * 食材信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:21:13
 */
public interface DiscussshicaixinxiDao extends BaseMapper<DiscussshicaixinxiEntity> {
	
	List<DiscussshicaixinxiView> selectListView(@Param("ew") Wrapper<DiscussshicaixinxiEntity> wrapper);

	List<DiscussshicaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshicaixinxiEntity> wrapper);
	
	DiscussshicaixinxiView selectView(@Param("ew") Wrapper<DiscussshicaixinxiEntity> wrapper);
	

}
