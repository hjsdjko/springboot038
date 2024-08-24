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

import com.entity.DiscussjiangzuoxinxiEntity;
import com.entity.view.DiscussjiangzuoxinxiView;

import com.service.DiscussjiangzuoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 讲座信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
@RestController
@RequestMapping("/discussjiangzuoxinxi")
public class DiscussjiangzuoxinxiController {
    @Autowired
    private DiscussjiangzuoxinxiService discussjiangzuoxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiangzuoxinxiEntity discussjiangzuoxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussjiangzuoxinxiEntity> ew = new EntityWrapper<DiscussjiangzuoxinxiEntity>();

		PageUtils page = discussjiangzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiangzuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiangzuoxinxiEntity discussjiangzuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiangzuoxinxiEntity> ew = new EntityWrapper<DiscussjiangzuoxinxiEntity>();

		PageUtils page = discussjiangzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiangzuoxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiangzuoxinxiEntity discussjiangzuoxinxi){
       	EntityWrapper<DiscussjiangzuoxinxiEntity> ew = new EntityWrapper<DiscussjiangzuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiangzuoxinxi, "discussjiangzuoxinxi")); 
        return R.ok().put("data", discussjiangzuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiangzuoxinxiEntity discussjiangzuoxinxi){
        EntityWrapper< DiscussjiangzuoxinxiEntity> ew = new EntityWrapper< DiscussjiangzuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiangzuoxinxi, "discussjiangzuoxinxi")); 
		DiscussjiangzuoxinxiView discussjiangzuoxinxiView =  discussjiangzuoxinxiService.selectView(ew);
		return R.ok("查询讲座信息评论表成功").put("data", discussjiangzuoxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiangzuoxinxiEntity discussjiangzuoxinxi = discussjiangzuoxinxiService.selectById(id);
        return R.ok().put("data", discussjiangzuoxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiangzuoxinxiEntity discussjiangzuoxinxi = discussjiangzuoxinxiService.selectById(id);
        return R.ok().put("data", discussjiangzuoxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjiangzuoxinxiEntity discussjiangzuoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiangzuoxinxi);
        discussjiangzuoxinxiService.insert(discussjiangzuoxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiangzuoxinxiEntity discussjiangzuoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiangzuoxinxi);
        discussjiangzuoxinxiService.insert(discussjiangzuoxinxi);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjiangzuoxinxiEntity discussjiangzuoxinxi = discussjiangzuoxinxiService.selectOne(new EntityWrapper<DiscussjiangzuoxinxiEntity>().eq("", username));
        return R.ok().put("data", discussjiangzuoxinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiangzuoxinxiEntity discussjiangzuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiangzuoxinxi);
        discussjiangzuoxinxiService.updateById(discussjiangzuoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjiangzuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiangzuoxinxiEntity discussjiangzuoxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiangzuoxinxiEntity> ew = new EntityWrapper<DiscussjiangzuoxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussjiangzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiangzuoxinxi), params), params));
        return R.ok().put("data", page);
    }










}
