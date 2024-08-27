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

import com.cl.entity.ShicaifenleiEntity;
import com.cl.entity.view.ShicaifenleiView;

import com.cl.service.ShicaifenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;

/**
 * 食材分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
@RestController
@RequestMapping("/shicaifenlei")
public class ShicaifenleiController {
    @Autowired
    private ShicaifenleiService shicaifenleiService;





    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShicaifenleiEntity shicaifenlei, 
		HttpServletRequest request){

        EntityWrapper<ShicaifenleiEntity> ew = new EntityWrapper<ShicaifenleiEntity>();


		PageUtils page = shicaifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shicaifenlei), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShicaifenleiEntity shicaifenlei, 
		HttpServletRequest request){
        EntityWrapper<ShicaifenleiEntity> ew = new EntityWrapper<ShicaifenleiEntity>();

		PageUtils page = shicaifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shicaifenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShicaifenleiEntity shicaifenlei){
       	EntityWrapper<ShicaifenleiEntity> ew = new EntityWrapper<ShicaifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shicaifenlei, "shicaifenlei")); 
        return R.ok().put("data", shicaifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShicaifenleiEntity shicaifenlei){
        EntityWrapper< ShicaifenleiEntity> ew = new EntityWrapper< ShicaifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shicaifenlei, "shicaifenlei")); 
		ShicaifenleiView shicaifenleiView =  shicaifenleiService.selectView(ew);
		return R.ok("查询食材分类成功").put("data", shicaifenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShicaifenleiEntity shicaifenlei = shicaifenleiService.selectById(id);
		shicaifenlei = shicaifenleiService.selectView(new EntityWrapper<ShicaifenleiEntity>().eq("id", id));
        return R.ok().put("data", shicaifenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShicaifenleiEntity shicaifenlei = shicaifenleiService.selectById(id);
		shicaifenlei = shicaifenleiService.selectView(new EntityWrapper<ShicaifenleiEntity>().eq("id", id));
        return R.ok().put("data", shicaifenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShicaifenleiEntity shicaifenlei, HttpServletRequest request){
    	shicaifenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shicaifenlei);

        shicaifenleiService.insert(shicaifenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShicaifenleiEntity shicaifenlei, HttpServletRequest request){
    	shicaifenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shicaifenlei);

        shicaifenleiService.insert(shicaifenlei);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShicaifenleiEntity shicaifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shicaifenlei);
        shicaifenleiService.updateById(shicaifenlei);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shicaifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
