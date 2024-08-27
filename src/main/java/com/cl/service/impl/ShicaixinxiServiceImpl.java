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


import com.cl.dao.ShicaixinxiDao;
import com.cl.entity.ShicaixinxiEntity;
import com.cl.service.ShicaixinxiService;
import com.cl.entity.view.ShicaixinxiView;

@Service("shicaixinxiService")
public class ShicaixinxiServiceImpl extends ServiceImpl<ShicaixinxiDao, ShicaixinxiEntity> implements ShicaixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShicaixinxiEntity> page = this.selectPage(
                new Query<ShicaixinxiEntity>(params).getPage(),
                new EntityWrapper<ShicaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShicaixinxiEntity> wrapper) {
		  Page<ShicaixinxiView> page =new Query<ShicaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShicaixinxiView> selectListView(Wrapper<ShicaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShicaixinxiView selectView(Wrapper<ShicaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
