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

import com.entity.ZhishifenleiEntity;
import com.entity.view.ZhishifenleiView;

import com.service.ZhishifenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 知识分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
@RestController
@RequestMapping("/zhishifenlei")
public class ZhishifenleiController {
    @Autowired
    private ZhishifenleiService zhishifenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhishifenleiEntity zhishifenlei,
		HttpServletRequest request){
        EntityWrapper<ZhishifenleiEntity> ew = new EntityWrapper<ZhishifenleiEntity>();

		PageUtils page = zhishifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishifenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhishifenleiEntity zhishifenlei, 
		HttpServletRequest request){
        EntityWrapper<ZhishifenleiEntity> ew = new EntityWrapper<ZhishifenleiEntity>();

		PageUtils page = zhishifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishifenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhishifenleiEntity zhishifenlei){
       	EntityWrapper<ZhishifenleiEntity> ew = new EntityWrapper<ZhishifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhishifenlei, "zhishifenlei")); 
        return R.ok().put("data", zhishifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhishifenleiEntity zhishifenlei){
        EntityWrapper< ZhishifenleiEntity> ew = new EntityWrapper< ZhishifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhishifenlei, "zhishifenlei")); 
		ZhishifenleiView zhishifenleiView =  zhishifenleiService.selectView(ew);
		return R.ok("查询知识分类成功").put("data", zhishifenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhishifenleiEntity zhishifenlei = zhishifenleiService.selectById(id);
        return R.ok().put("data", zhishifenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhishifenleiEntity zhishifenlei = zhishifenleiService.selectById(id);
        return R.ok().put("data", zhishifenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhishifenleiEntity zhishifenlei, HttpServletRequest request){
        if(zhishifenleiService.selectCount(new EntityWrapper<ZhishifenleiEntity>().eq("zhishifenlei", zhishifenlei.getZhishifenlei()))>0) {
            return R.error("知识分类已存在");
        }
    	//ValidatorUtils.validateEntity(zhishifenlei);
        zhishifenleiService.insert(zhishifenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhishifenleiEntity zhishifenlei, HttpServletRequest request){
        if(zhishifenleiService.selectCount(new EntityWrapper<ZhishifenleiEntity>().eq("zhishifenlei", zhishifenlei.getZhishifenlei()))>0) {
            return R.error("知识分类已存在");
        }
    	//ValidatorUtils.validateEntity(zhishifenlei);
        zhishifenleiService.insert(zhishifenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhishifenleiEntity zhishifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhishifenlei);
        if(zhishifenleiService.selectCount(new EntityWrapper<ZhishifenleiEntity>().ne("id", zhishifenlei.getId()).eq("zhishifenlei", zhishifenlei.getZhishifenlei()))>0) {
            return R.error("知识分类已存在");
        }
        zhishifenleiService.updateById(zhishifenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhishifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
