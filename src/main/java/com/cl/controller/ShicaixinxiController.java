package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ShicaixinxiEntity;
import com.cl.entity.view.ShicaixinxiView;

import com.cl.service.ShicaixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 食材信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
@RestController
@RequestMapping("/shicaixinxi")
public class ShicaixinxiController {
    @Autowired
    private ShicaixinxiService shicaixinxiService;



    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShicaixinxiEntity shicaixinxi, 
		HttpServletRequest request){

        EntityWrapper<ShicaixinxiEntity> ew = new EntityWrapper<ShicaixinxiEntity>();


		PageUtils page = shicaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shicaixinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShicaixinxiEntity shicaixinxi, 
		HttpServletRequest request){
        EntityWrapper<ShicaixinxiEntity> ew = new EntityWrapper<ShicaixinxiEntity>();

		PageUtils page = shicaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shicaixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShicaixinxiEntity shicaixinxi){
       	EntityWrapper<ShicaixinxiEntity> ew = new EntityWrapper<ShicaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shicaixinxi, "shicaixinxi")); 
        return R.ok().put("data", shicaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShicaixinxiEntity shicaixinxi){
        EntityWrapper< ShicaixinxiEntity> ew = new EntityWrapper< ShicaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shicaixinxi, "shicaixinxi")); 
		ShicaixinxiView shicaixinxiView =  shicaixinxiService.selectView(ew);
		return R.ok("查询食材信息成功").put("data", shicaixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShicaixinxiEntity shicaixinxi = shicaixinxiService.selectById(id);
		shicaixinxi = shicaixinxiService.selectView(new EntityWrapper<ShicaixinxiEntity>().eq("id", id));
        return R.ok().put("data", shicaixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShicaixinxiEntity shicaixinxi = shicaixinxiService.selectById(id);
		shicaixinxi = shicaixinxiService.selectView(new EntityWrapper<ShicaixinxiEntity>().eq("id", id));
        return R.ok().put("data", shicaixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShicaixinxiEntity shicaixinxi, HttpServletRequest request){
    	shicaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shicaixinxi);

        shicaixinxiService.insert(shicaixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShicaixinxiEntity shicaixinxi, HttpServletRequest request){
    	shicaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shicaixinxi);

        shicaixinxiService.insert(shicaixinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShicaixinxiEntity shicaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shicaixinxi);
        shicaixinxiService.updateById(shicaixinxi);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shicaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
