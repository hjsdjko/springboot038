package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiangzuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiangzuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiangzuoxinxiView;


/**
 * 讲座信息
 *
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public interface JiangzuoxinxiService extends IService<JiangzuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiangzuoxinxiVO> selectListVO(Wrapper<JiangzuoxinxiEntity> wrapper);
   	
   	JiangzuoxinxiVO selectVO(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
   	
   	List<JiangzuoxinxiView> selectListView(Wrapper<JiangzuoxinxiEntity> wrapper);
   	
   	JiangzuoxinxiView selectView(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiangzuoxinxiEntity> wrapper);

   	

}

