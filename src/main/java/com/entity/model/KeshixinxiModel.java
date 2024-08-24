package com.entity.model;

import com.entity.KeshixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 科室信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
public class KeshixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 主治医生
	 */
	
	private String zhuzhiyisheng;
		
	/**
	 * 服务时间
	 */
	
	private String fuwushijian;
		
	/**
	 * 治疗症状
	 */
	
	private String zhiliaozhengzhuang;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：主治医生
	 */
	 
	public void setZhuzhiyisheng(String zhuzhiyisheng) {
		this.zhuzhiyisheng = zhuzhiyisheng;
	}
	
	/**
	 * 获取：主治医生
	 */
	public String getZhuzhiyisheng() {
		return zhuzhiyisheng;
	}
				
	
	/**
	 * 设置：服务时间
	 */
	 
	public void setFuwushijian(String fuwushijian) {
		this.fuwushijian = fuwushijian;
	}
	
	/**
	 * 获取：服务时间
	 */
	public String getFuwushijian() {
		return fuwushijian;
	}
				
	
	/**
	 * 设置：治疗症状
	 */
	 
	public void setZhiliaozhengzhuang(String zhiliaozhengzhuang) {
		this.zhiliaozhengzhuang = zhiliaozhengzhuang;
	}
	
	/**
	 * 获取：治疗症状
	 */
	public String getZhiliaozhengzhuang() {
		return zhiliaozhengzhuang;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
