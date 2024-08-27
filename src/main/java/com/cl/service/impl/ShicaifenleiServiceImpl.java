package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShicaifenleiDao;
import com.cl.entity.ShicaifenleiEntity;
import com.cl.service.ShicaifenleiService;
import com.cl.entity.view.ShicaifenleiView;

@Service("shicaifenleiService")
public class ShicaifenleiServiceImpl extends ServiceImpl<ShicaifenleiDao, ShicaifenleiEntity> implements ShicaifenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShicaifenleiEntity> page = this.selectPage(
                new Query<ShicaifenleiEntity>(params).getPage(),
                new EntityWrapper<ShicaifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShicaifenleiEntity> wrapper) {
		  Page<ShicaifenleiView> page =new Query<ShicaifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShicaifenleiView> selectListView(Wrapper<ShicaifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShicaifenleiView selectView(Wrapper<ShicaifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
