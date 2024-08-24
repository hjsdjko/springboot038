package com.entity.view;

import com.entity.DiscusszhishikepuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 知识科普评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
@TableName("discusszhishikepu")
public class DiscusszhishikepuView  extends DiscusszhishikepuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhishikepuView(){
	}
 
 	public DiscusszhishikepuView(DiscusszhishikepuEntity discusszhishikepuEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhishikepuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
