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

import com.entity.ZhishikepuEntity;
import com.entity.view.ZhishikepuView;

import com.service.ZhishikepuService;
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
 * 知识科普
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
@RestController
@RequestMapping("/zhishikepu")
public class ZhishikepuController {
    @Autowired
    private ZhishikepuService zhishikepuService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhishikepuEntity zhishikepu,
		HttpServletRequest request){
        EntityWrapper<ZhishikepuEntity> ew = new EntityWrapper<ZhishikepuEntity>();

		PageUtils page = zhishikepuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishikepu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhishikepuEntity zhishikepu, 
		HttpServletRequest request){
        EntityWrapper<ZhishikepuEntity> ew = new EntityWrapper<ZhishikepuEntity>();

		PageUtils page = zhishikepuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishikepu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhishikepuEntity zhishikepu){
       	EntityWrapper<ZhishikepuEntity> ew = new EntityWrapper<ZhishikepuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhishikepu, "zhishikepu")); 
        return R.ok().put("data", zhishikepuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhishikepuEntity zhishikepu){
        EntityWrapper< ZhishikepuEntity> ew = new EntityWrapper< ZhishikepuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhishikepu, "zhishikepu")); 
		ZhishikepuView zhishikepuView =  zhishikepuService.selectView(ew);
		return R.ok("查询知识科普成功").put("data", zhishikepuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhishikepuEntity zhishikepu = zhishikepuService.selectById(id);
		zhishikepu.setClicktime(new Date());
		zhishikepuService.updateById(zhishikepu);
        zhishikepu = zhishikepuService.selectView(new EntityWrapper<ZhishikepuEntity>().eq("id", id));
        return R.ok().put("data", zhishikepu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhishikepuEntity zhishikepu = zhishikepuService.selectById(id);
		zhishikepu.setClicktime(new Date());
		zhishikepuService.updateById(zhishikepu);
        zhishikepu = zhishikepuService.selectView(new EntityWrapper<ZhishikepuEntity>().eq("id", id));
        return R.ok().put("data", zhishikepu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhishikepuEntity zhishikepu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhishikepu);
        zhishikepuService.insert(zhishikepu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhishikepuEntity zhishikepu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zhishikepu);
        zhishikepuService.insert(zhishikepu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhishikepuEntity zhishikepu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhishikepu);
        zhishikepuService.updateById(zhishikepu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhishikepuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ZhishikepuEntity zhishikepu, HttpServletRequest request,String pre){
        EntityWrapper<ZhishikepuEntity> ew = new EntityWrapper<ZhishikepuEntity>();
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
		PageUtils page = zhishikepuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishikepu), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ZhishikepuEntity zhishikepu, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "zhishifenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "zhishikepu").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ZhishikepuEntity> zhishikepuList = new ArrayList<ZhishikepuEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                zhishikepuList.addAll(zhishikepuService.selectList(new EntityWrapper<ZhishikepuEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ZhishikepuEntity> ew = new EntityWrapper<ZhishikepuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = zhishikepuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishikepu), params), params));
        List<ZhishikepuEntity> pageList = (List<ZhishikepuEntity>)page.getList();
        if(zhishikepuList.size()<limit) {
            int toAddNum = (limit-zhishikepuList.size())<=pageList.size()?(limit-zhishikepuList.size()):pageList.size();
            for(ZhishikepuEntity o1 : pageList) {
                boolean addFlag = true;
                for(ZhishikepuEntity o2 : zhishikepuList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    zhishikepuList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(zhishikepuList.size()>limit) {
            zhishikepuList = zhishikepuList.subList(0, limit);
        }
        page.setList(zhishikepuList);
        return R.ok().put("data", page);
    }








}
