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

import com.entity.JiangzuobaomingEntity;
import com.entity.view.JiangzuobaomingView;

import com.service.JiangzuobaomingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 讲座报名
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
@RestController
@RequestMapping("/jiangzuobaoming")
public class JiangzuobaomingController {
    @Autowired
    private JiangzuobaomingService jiangzuobaomingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiangzuobaomingEntity jiangzuobaoming,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiangzuobaoming.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yisheng")) {
			jiangzuobaoming.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiangzuobaomingEntity> ew = new EntityWrapper<JiangzuobaomingEntity>();

		PageUtils page = jiangzuobaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangzuobaoming), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiangzuobaomingEntity jiangzuobaoming, 
		HttpServletRequest request){
        EntityWrapper<JiangzuobaomingEntity> ew = new EntityWrapper<JiangzuobaomingEntity>();

		PageUtils page = jiangzuobaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiangzuobaoming), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiangzuobaomingEntity jiangzuobaoming){
       	EntityWrapper<JiangzuobaomingEntity> ew = new EntityWrapper<JiangzuobaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiangzuobaoming, "jiangzuobaoming")); 
        return R.ok().put("data", jiangzuobaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiangzuobaomingEntity jiangzuobaoming){
        EntityWrapper< JiangzuobaomingEntity> ew = new EntityWrapper< JiangzuobaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiangzuobaoming, "jiangzuobaoming")); 
		JiangzuobaomingView jiangzuobaomingView =  jiangzuobaomingService.selectView(ew);
		return R.ok("查询讲座报名成功").put("data", jiangzuobaomingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiangzuobaomingEntity jiangzuobaoming = jiangzuobaomingService.selectById(id);
        return R.ok().put("data", jiangzuobaoming);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiangzuobaomingEntity jiangzuobaoming = jiangzuobaomingService.selectById(id);
        return R.ok().put("data", jiangzuobaoming);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiangzuobaomingEntity jiangzuobaoming, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiangzuobaoming);
        jiangzuobaomingService.insert(jiangzuobaoming);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiangzuobaomingEntity jiangzuobaoming, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiangzuobaoming);
        jiangzuobaomingService.insert(jiangzuobaoming);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiangzuobaomingEntity jiangzuobaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiangzuobaoming);
        jiangzuobaomingService.updateById(jiangzuobaoming);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JiangzuobaomingEntity> list = new ArrayList<JiangzuobaomingEntity>();
        for(Long id : ids) {
            JiangzuobaomingEntity jiangzuobaoming = jiangzuobaomingService.selectById(id);
            jiangzuobaoming.setSfsh(sfsh);
            jiangzuobaoming.setShhf(shhf);
            list.add(jiangzuobaoming);
        }
        jiangzuobaomingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiangzuobaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
