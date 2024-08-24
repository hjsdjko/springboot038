package com.entity.vo;

import com.entity.JiangzuoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 讲座信息
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public class JiangzuoxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 讲座类型
	 */
	
	private String jiangzuoleixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 讲座地点
	 */
	
	private String jiangzuodidian;
		
	/**
	 * 讲座详情
	 */
	
	private String jiangzuoxiangqing;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 讲师
	 */
	
	private String yishengxingming;
		
	/**
	 * 开始时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date kaishishijian;
		
	/**
	 * 倒计结束时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date reversetime;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：讲座类型
	 */
	 
	public void setJiangzuoleixing(String jiangzuoleixing) {
		this.jiangzuoleixing = jiangzuoleixing;
	}
	
	/**
	 * 获取：讲座类型
	 */
	public String getJiangzuoleixing() {
		return jiangzuoleixing;
	}
				
	
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
	 * 设置：讲座地点
	 */
	 
	public void setJiangzuodidian(String jiangzuodidian) {
		this.jiangzuodidian = jiangzuodidian;
	}
	
	/**
	 * 获取：讲座地点
	 */
	public String getJiangzuodidian() {
		return jiangzuodidian;
	}
				
	
	/**
	 * 设置：讲座详情
	 */
	 
	public void setJiangzuoxiangqing(String jiangzuoxiangqing) {
		this.jiangzuoxiangqing = jiangzuoxiangqing;
	}
	
	/**
	 * 获取：讲座详情
	 */
	public String getJiangzuoxiangqing() {
		return jiangzuoxiangqing;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：讲师
	 */
	 
	public void setYishengxingming(String yishengxingming) {
		this.yishengxingming = yishengxingming;
	}
	
	/**
	 * 获取：讲师
	 */
	public String getYishengxingming() {
		return yishengxingming;
	}
				
	
	/**
	 * 设置：开始时间
	 */
	 
	public void setKaishishijian(Date kaishishijian) {
		this.kaishishijian = kaishishijian;
	}
	
	/**
	 * 获取：开始时间
	 */
	public Date getKaishishijian() {
		return kaishishijian;
	}
				
	
	/**
	 * 设置：倒计结束时间
	 */
	 
	public void setReversetime(Date reversetime) {
		this.reversetime = reversetime;
	}
	
	/**
	 * 获取：倒计结束时间
	 */
	public Date getReversetime() {
		return reversetime;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
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
