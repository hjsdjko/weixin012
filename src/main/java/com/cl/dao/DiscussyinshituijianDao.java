package com.cl.dao;

import com.cl.entity.DiscussyinshituijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinshituijianView;


/**
 * 饮食推荐评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-12 10:21:13
 */
public interface DiscussyinshituijianDao extends BaseMapper<DiscussyinshituijianEntity> {
	
	List<DiscussyinshituijianView> selectListView(@Param("ew") Wrapper<DiscussyinshituijianEntity> wrapper);

	List<DiscussyinshituijianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyinshituijianEntity> wrapper);
	
	DiscussyinshituijianView selectView(@Param("ew") Wrapper<DiscussyinshituijianEntity> wrapper);
	

}
