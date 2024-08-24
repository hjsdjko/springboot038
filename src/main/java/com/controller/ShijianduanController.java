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

import com.entity.ShijianduanEntity;
import com.entity.view.ShijianduanView;

import com.service.ShijianduanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 时间段
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
@RestController
@RequestMapping("/shijianduan")
public class ShijianduanController {
    @Autowired
    private ShijianduanService shijianduanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShijianduanEntity shijianduan,
		HttpServletRequest request){
        EntityWrapper<ShijianduanEntity> ew = new EntityWrapper<ShijianduanEntity>();

		PageUtils page = shijianduanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijianduan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShijianduanEntity shijianduan, 
		HttpServletRequest request){
        EntityWrapper<ShijianduanEntity> ew = new EntityWrapper<ShijianduanEntity>();

		PageUtils page = shijianduanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijianduan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShijianduanEntity shijianduan){
       	EntityWrapper<ShijianduanEntity> ew = new EntityWrapper<ShijianduanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shijianduan, "shijianduan")); 
        return R.ok().put("data", shijianduanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShijianduanEntity shijianduan){
        EntityWrapper< ShijianduanEntity> ew = new EntityWrapper< ShijianduanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shijianduan, "shijianduan")); 
		ShijianduanView shijianduanView =  shijianduanService.selectView(ew);
		return R.ok("查询时间段成功").put("data", shijianduanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShijianduanEntity shijianduan = shijianduanService.selectById(id);
        return R.ok().put("data", shijianduan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShijianduanEntity shijianduan = shijianduanService.selectById(id);
        return R.ok().put("data", shijianduan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShijianduanEntity shijianduan, HttpServletRequest request){
        if(shijianduanService.selectCount(new EntityWrapper<ShijianduanEntity>().eq("shijianduan", shijianduan.getShijianduan()))>0) {
            return R.error("时间段已存在");
        }
    	//ValidatorUtils.validateEntity(shijianduan);
        shijianduanService.insert(shijianduan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShijianduanEntity shijianduan, HttpServletRequest request){
        if(shijianduanService.selectCount(new EntityWrapper<ShijianduanEntity>().eq("shijianduan", shijianduan.getShijianduan()))>0) {
            return R.error("时间段已存在");
        }
    	//ValidatorUtils.validateEntity(shijianduan);
        shijianduanService.insert(shijianduan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShijianduanEntity shijianduan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shijianduan);
        if(shijianduanService.selectCount(new EntityWrapper<ShijianduanEntity>().ne("id", shijianduan.getId()).eq("shijianduan", shijianduan.getShijianduan()))>0) {
            return R.error("时间段已存在");
        }
        shijianduanService.updateById(shijianduan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shijianduanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
