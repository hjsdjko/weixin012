package com.cl.entity.view;

import com.cl.entity.DiscussyinshituijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 饮食推荐评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-12 10:21:13
 */
@TableName("discussyinshituijian")
public class DiscussyinshituijianView  extends DiscussyinshituijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussyinshituijianView(){
	}
 
 	public DiscussyinshituijianView(DiscussyinshituijianEntity discussyinshituijianEntity){
 	try {
			BeanUtils.copyProperties(this, discussyinshituijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
