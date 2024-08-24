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

import com.entity.KaiyaoxinxiEntity;
import com.entity.view.KaiyaoxinxiView;

import com.service.KaiyaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 开药信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
@RestController
@RequestMapping("/kaiyaoxinxi")
public class KaiyaoxinxiController {
    @Autowired
    private KaiyaoxinxiService kaiyaoxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaiyaoxinxiEntity kaiyaoxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			kaiyaoxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yisheng")) {
			kaiyaoxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaiyaoxinxiEntity> ew = new EntityWrapper<KaiyaoxinxiEntity>();

		PageUtils page = kaiyaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaiyaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaiyaoxinxiEntity kaiyaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<KaiyaoxinxiEntity> ew = new EntityWrapper<KaiyaoxinxiEntity>();

		PageUtils page = kaiyaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaiyaoxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaiyaoxinxiEntity kaiyaoxinxi){
       	EntityWrapper<KaiyaoxinxiEntity> ew = new EntityWrapper<KaiyaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaiyaoxinxi, "kaiyaoxinxi")); 
        return R.ok().put("data", kaiyaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaiyaoxinxiEntity kaiyaoxinxi){
        EntityWrapper< KaiyaoxinxiEntity> ew = new EntityWrapper< KaiyaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaiyaoxinxi, "kaiyaoxinxi")); 
		KaiyaoxinxiView kaiyaoxinxiView =  kaiyaoxinxiService.selectView(ew);
		return R.ok("查询开药信息成功").put("data", kaiyaoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaiyaoxinxiEntity kaiyaoxinxi = kaiyaoxinxiService.selectById(id);
        return R.ok().put("data", kaiyaoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaiyaoxinxiEntity kaiyaoxinxi = kaiyaoxinxiService.selectById(id);
        return R.ok().put("data", kaiyaoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaiyaoxinxiEntity kaiyaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaiyaoxinxi);
        kaiyaoxinxiService.insert(kaiyaoxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaiyaoxinxiEntity kaiyaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kaiyaoxinxi);
        kaiyaoxinxiService.insert(kaiyaoxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaiyaoxinxiEntity kaiyaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaiyaoxinxi);
        kaiyaoxinxiService.updateById(kaiyaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaiyaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
