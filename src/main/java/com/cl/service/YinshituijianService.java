package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinshituijianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinshituijianView;


/**
 * 饮食推荐
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:21:13
 */
public interface YinshituijianService extends IService<YinshituijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinshituijianView> selectListView(Wrapper<YinshituijianEntity> wrapper);
   	
   	YinshituijianView selectView(@Param("ew") Wrapper<YinshituijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinshituijianEntity> wrapper);
   	

}

