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

import com.entity.YishengpaibanEntity;
import com.entity.view.YishengpaibanView;

import com.service.YishengpaibanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 医生排班
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
@RestController
@RequestMapping("/yishengpaiban")
public class YishengpaibanController {
    @Autowired
    private YishengpaibanService yishengpaibanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YishengpaibanEntity yishengpaiban,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			yishengpaiban.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YishengpaibanEntity> ew = new EntityWrapper<YishengpaibanEntity>();

		PageUtils page = yishengpaibanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishengpaiban), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YishengpaibanEntity yishengpaiban, 
		HttpServletRequest request){
        EntityWrapper<YishengpaibanEntity> ew = new EntityWrapper<YishengpaibanEntity>();

		PageUtils page = yishengpaibanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yishengpaiban), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YishengpaibanEntity yishengpaiban){
       	EntityWrapper<YishengpaibanEntity> ew = new EntityWrapper<YishengpaibanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yishengpaiban, "yishengpaiban")); 
        return R.ok().put("data", yishengpaibanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YishengpaibanEntity yishengpaiban){
        EntityWrapper< YishengpaibanEntity> ew = new EntityWrapper< YishengpaibanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yishengpaiban, "yishengpaiban")); 
		YishengpaibanView yishengpaibanView =  yishengpaibanService.selectView(ew);
		return R.ok("查询医生排班成功").put("data", yishengpaibanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YishengpaibanEntity yishengpaiban = yishengpaibanService.selectById(id);
        return R.ok().put("data", yishengpaiban);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YishengpaibanEntity yishengpaiban = yishengpaibanService.selectById(id);
        return R.ok().put("data", yishengpaiban);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YishengpaibanEntity yishengpaiban, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yishengpaiban);
        yishengpaibanService.insert(yishengpaiban);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YishengpaibanEntity yishengpaiban, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yishengpaiban);
        yishengpaibanService.insert(yishengpaiban);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YishengpaibanEntity yishengpaiban, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yishengpaiban);
        yishengpaibanService.updateById(yishengpaiban);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yishengpaibanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
