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


import com.cl.dao.DiscussyinshituijianDao;
import com.cl.entity.DiscussyinshituijianEntity;
import com.cl.service.DiscussyinshituijianService;
import com.cl.entity.view.DiscussyinshituijianView;

@Service("discussyinshituijianService")
public class DiscussyinshituijianServiceImpl extends ServiceImpl<DiscussyinshituijianDao, DiscussyinshituijianEntity> implements DiscussyinshituijianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyinshituijianEntity> page = this.selectPage(
                new Query<DiscussyinshituijianEntity>(params).getPage(),
                new EntityWrapper<DiscussyinshituijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyinshituijianEntity> wrapper) {
		  Page<DiscussyinshituijianView> page =new Query<DiscussyinshituijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussyinshituijianView> selectListView(Wrapper<DiscussyinshituijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyinshituijianView selectView(Wrapper<DiscussyinshituijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
