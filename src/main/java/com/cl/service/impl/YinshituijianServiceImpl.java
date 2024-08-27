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


import com.cl.dao.YinshituijianDao;
import com.cl.entity.YinshituijianEntity;
import com.cl.service.YinshituijianService;
import com.cl.entity.view.YinshituijianView;

@Service("yinshituijianService")
public class YinshituijianServiceImpl extends ServiceImpl<YinshituijianDao, YinshituijianEntity> implements YinshituijianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinshituijianEntity> page = this.selectPage(
                new Query<YinshituijianEntity>(params).getPage(),
                new EntityWrapper<YinshituijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinshituijianEntity> wrapper) {
		  Page<YinshituijianView> page =new Query<YinshituijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YinshituijianView> selectListView(Wrapper<YinshituijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinshituijianView selectView(Wrapper<YinshituijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
