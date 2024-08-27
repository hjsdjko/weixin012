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

import com.cl.entity.YinshituijianEntity;
import com.cl.entity.view.YinshituijianView;

import com.cl.service.YinshituijianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 饮食推荐
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-12 10:21:13
 */
@RestController
@RequestMapping("/yinshituijian")
public class YinshituijianController {
    @Autowired
    private YinshituijianService yinshituijianService;



    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinshituijianEntity yinshituijian, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		yinshituijian.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

        EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();


		PageUtils page = yinshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshituijian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinshituijianEntity yinshituijian, 
		HttpServletRequest request){
        EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();

		PageUtils page = yinshituijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinshituijian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinshituijianEntity yinshituijian){
       	EntityWrapper<YinshituijianEntity> ew = new EntityWrapper<YinshituijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinshituijian, "yinshituijian")); 
        return R.ok().put("data", yinshituijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinshituijianEntity yinshituijian){
        EntityWrapper< YinshituijianEntity> ew = new EntityWrapper< YinshituijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinshituijian, "yinshituijian")); 
		YinshituijianView yinshituijianView =  yinshituijianService.selectView(ew);
		return R.ok("查询饮食推荐成功").put("data", yinshituijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinshituijianEntity yinshituijian = yinshituijianService.selectById(id);
		yinshituijian = yinshituijianService.selectView(new EntityWrapper<YinshituijianEntity>().eq("id", id));
        return R.ok().put("data", yinshituijian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinshituijianEntity yinshituijian = yinshituijianService.selectById(id);
		yinshituijian = yinshituijianService.selectView(new EntityWrapper<YinshituijianEntity>().eq("id", id));
        return R.ok().put("data", yinshituijian);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        YinshituijianEntity yinshituijian = yinshituijianService.selectById(id);
        if(type.equals("1")) {
        	yinshituijian.setThumbsupnum(yinshituijian.getThumbsupnum()+1);
        } else {
        	yinshituijian.setCrazilynum(yinshituijian.getCrazilynum()+1);
        }
        yinshituijianService.updateById(yinshituijian);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinshituijianEntity yinshituijian, HttpServletRequest request){
    	yinshituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshituijian);
    	yinshituijian.setUserid((Long)request.getSession().getAttribute("userId"));

        yinshituijianService.insert(yinshituijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinshituijianEntity yinshituijian, HttpServletRequest request){
    	yinshituijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yinshituijian);

        yinshituijianService.insert(yinshituijian);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinshituijianEntity yinshituijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinshituijian);
        yinshituijianService.updateById(yinshituijian);//全部更新
        return R.ok();
    }

    /**  
     * 审核 
     */   
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YinshituijianEntity> list = new ArrayList<YinshituijianEntity>();
        for(Long id : ids) {
            YinshituijianEntity yinshituijian = yinshituijianService.selectById(id);
            yinshituijian.setSfsh(sfsh);
            yinshituijian.setShhf(shhf);
            list.add(yinshituijian);
        }    
        yinshituijianService.updateBatchById(list);
        return R.ok();
    }    
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinshituijianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







}
