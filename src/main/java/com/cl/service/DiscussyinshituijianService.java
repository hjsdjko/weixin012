package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussyinshituijianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussyinshituijianView;


/**
 * 饮食推荐评论表
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:21:13
 */
public interface DiscussyinshituijianService extends IService<DiscussyinshituijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyinshituijianView> selectListView(Wrapper<DiscussyinshituijianEntity> wrapper);
   	
   	DiscussyinshituijianView selectView(@Param("ew") Wrapper<DiscussyinshituijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyinshituijianEntity> wrapper);
   	

}

