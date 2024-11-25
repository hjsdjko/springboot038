package com.entity.view;

import com.entity.KaiyaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 开药信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
@TableName("kaiyaoxinxi")
public class KaiyaoxinxiView  extends KaiyaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaiyaoxinxiView(){
	}
 
 	public KaiyaoxinxiView(KaiyaoxinxiEntity kaiyaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, kaiyaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
