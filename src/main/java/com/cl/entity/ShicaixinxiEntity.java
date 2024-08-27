package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 食材信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-12 10:21:12
 */
@TableName("shicaixinxi")
public class ShicaixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShicaixinxiEntity() {
		
	}
	
	public ShicaixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 食材图片
	 */
					
	private String shicaitupian;
	
	/**
	 * 食材名称
	 */
					
	private String shicaimingcheng;
	
	/**
	 * 食材分类
	 */
					
	private String shicaifenlei;
	
	/**
	 * 食材详情
	 */
					
	private String shicaixiangqing;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：食材图片
	 */
	public void setShicaitupian(String shicaitupian) {
		this.shicaitupian = shicaitupian;
	}
	/**
	 * 获取：食材图片
	 */
	public String getShicaitupian() {
		return shicaitupian;
	}
	/**
	 * 设置：食材名称
	 */
	public void setShicaimingcheng(String shicaimingcheng) {
		this.shicaimingcheng = shicaimingcheng;
	}
	/**
	 * 获取：食材名称
	 */
	public String getShicaimingcheng() {
		return shicaimingcheng;
	}
	/**
	 * 设置：食材分类
	 */
	public void setShicaifenlei(String shicaifenlei) {
		this.shicaifenlei = shicaifenlei;
	}
	/**
	 * 获取：食材分类
	 */
	public String getShicaifenlei() {
		return shicaifenlei;
	}
	/**
	 * 设置：食材详情
	 */
	public void setShicaixiangqing(String shicaixiangqing) {
		this.shicaixiangqing = shicaixiangqing;
	}
	/**
	 * 获取：食材详情
	 */
	public String getShicaixiangqing() {
		return shicaixiangqing;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
