package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShicaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShicaixinxiView;


/**
 * 食材信息
 *
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
public interface ShicaixinxiService extends IService<ShicaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShicaixinxiView> selectListView(Wrapper<ShicaixinxiEntity> wrapper);
   	
   	ShicaixinxiView selectView(@Param("ew") Wrapper<ShicaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShicaixinxiEntity> wrapper);
   	

}

