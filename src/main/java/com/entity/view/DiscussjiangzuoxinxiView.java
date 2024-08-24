package com.entity.view;

import com.entity.DiscussjiangzuoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 讲座信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
@TableName("discussjiangzuoxinxi")
public class DiscussjiangzuoxinxiView  extends DiscussjiangzuoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussjiangzuoxinxiView(){
	}
 
 	public DiscussjiangzuoxinxiView(DiscussjiangzuoxinxiEntity discussjiangzuoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussjiangzuoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}