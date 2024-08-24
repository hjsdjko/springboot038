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

import com.entity.DiscusszhishikepuEntity;
import com.entity.view.DiscusszhishikepuView;

import com.service.DiscusszhishikepuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 知识科普评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
@RestController
@RequestMapping("/discusszhishikepu")
public class DiscusszhishikepuController {
    @Autowired
    private DiscusszhishikepuService discusszhishikepuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhishikepuEntity discusszhishikepu,
		HttpServletRequest request){
        EntityWrapper<DiscusszhishikepuEntity> ew = new EntityWrapper<DiscusszhishikepuEntity>();

		PageUtils page = discusszhishikepuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhishikepu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhishikepuEntity discusszhishikepu, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhishikepuEntity> ew = new EntityWrapper<DiscusszhishikepuEntity>();

		PageUtils page = discusszhishikepuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhishikepu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhishikepuEntity discusszhishikepu){
       	EntityWrapper<DiscusszhishikepuEntity> ew = new EntityWrapper<DiscusszhishikepuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhishikepu, "discusszhishikepu")); 
        return R.ok().put("data", discusszhishikepuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhishikepuEntity discusszhishikepu){
        EntityWrapper< DiscusszhishikepuEntity> ew = new EntityWrapper< DiscusszhishikepuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhishikepu, "discusszhishikepu")); 
		DiscusszhishikepuView discusszhishikepuView =  discusszhishikepuService.selectView(ew);
		return R.ok("查询知识科普评论表成功").put("data", discusszhishikepuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhishikepuEntity discusszhishikepu = discusszhishikepuService.selectById(id);
        return R.ok().put("data", discusszhishikepu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhishikepuEntity discusszhishikepu = discusszhishikepuService.selectById(id);
        return R.ok().put("data", discusszhishikepu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhishikepuEntity discusszhishikepu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusszhishikepu);
        discusszhishikepuService.insert(discusszhishikepu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhishikepuEntity discusszhishikepu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusszhishikepu);
        discusszhishikepuService.insert(discusszhishikepu);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusszhishikepuEntity discusszhishikepu = discusszhishikepuService.selectOne(new EntityWrapper<DiscusszhishikepuEntity>().eq("", username));
        return R.ok().put("data", discusszhishikepu);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusszhishikepuEntity discusszhishikepu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhishikepu);
        discusszhishikepuService.updateById(discusszhishikepu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhishikepuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusszhishikepuEntity discusszhishikepu, HttpServletRequest request,String pre){
        EntityWrapper<DiscusszhishikepuEntity> ew = new EntityWrapper<DiscusszhishikepuEntity>();
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
		PageUtils page = discusszhishikepuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhishikepu), params), params));
        return R.ok().put("data", page);
    }










}
