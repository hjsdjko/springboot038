package com.controller;

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

import com.utils.ValidatorUtils;
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
import com.annotation.IgnoreAuth;

import com.entity.JiangzuoxinxiEntity;
import com.entity.view.JiangzuoxinxiView;

import com.service.JiangzuoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 讲座信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
@RestController
@RequestMapping("/jiangzuoxinxi")
public class JiangzuoxinxiController {
    @Autowired
    private JiangzuoxinxiService jiangzuoxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiangzuoxinxiEntity jiangzuoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			jiangzuoxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiangzuoxinxiEntity> ew = new EntityWrapper<JiangzuoxinxiEntity>();

		PageUtils page = jiangzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangzuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiangzuoxinxiEntity jiangzuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiangzuoxinxiEntity> ew = new EntityWrapper<JiangzuoxinxiEntity>();

		PageUtils page = jiangzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangzuoxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiangzuoxinxiEntity jiangzuoxinxi){
       	EntityWrapper<JiangzuoxinxiEntity> ew = new EntityWrapper<JiangzuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiangzuoxinxi, "jiangzuoxinxi")); 
        return R.ok().put("data", jiangzuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiangzuoxinxiEntity jiangzuoxinxi){
        EntityWrapper< JiangzuoxinxiEntity> ew = new EntityWrapper< JiangzuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiangzuoxinxi, "jiangzuoxinxi")); 
		JiangzuoxinxiView jiangzuoxinxiView =  jiangzuoxinxiService.selectView(ew);
		return R.ok("查询讲座信息成功").put("data", jiangzuoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiangzuoxinxiEntity jiangzuoxinxi = jiangzuoxinxiService.selectById(id);
        return R.ok().put("data", jiangzuoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiangzuoxinxiEntity jiangzuoxinxi = jiangzuoxinxiService.selectById(id);
        return R.ok().put("data", jiangzuoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiangzuoxinxiEntity jiangzuoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiangzuoxinxi);
        jiangzuoxinxiService.insert(jiangzuoxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiangzuoxinxiEntity jiangzuoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiangzuoxinxi);
        jiangzuoxinxiService.insert(jiangzuoxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiangzuoxinxiEntity jiangzuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiangzuoxinxi);
        jiangzuoxinxiService.updateById(jiangzuoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiangzuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
