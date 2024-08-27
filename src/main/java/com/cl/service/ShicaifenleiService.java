package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShicaifenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShicaifenleiView;


/**
 * 食材分类
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
public interface ShicaifenleiService extends IService<ShicaifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShicaifenleiView> selectListView(Wrapper<ShicaifenleiEntity> wrapper);
   	
   	ShicaifenleiView selectView(@Param("ew") Wrapper<ShicaifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShicaifenleiEntity> wrapper);
   	

}

