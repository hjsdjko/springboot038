package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiangzuobaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiangzuobaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiangzuobaomingView;


/**
 * 讲座报名
 *
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public interface JiangzuobaomingService extends IService<JiangzuobaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiangzuobaomingVO> selectListVO(Wrapper<JiangzuobaomingEntity> wrapper);
   	
   	JiangzuobaomingVO selectVO(@Param("ew") Wrapper<JiangzuobaomingEntity> wrapper);
   	
   	List<JiangzuobaomingView> selectListView(Wrapper<JiangzuobaomingEntity> wrapper);
   	
   	JiangzuobaomingView selectView(@Param("ew") Wrapper<JiangzuobaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiangzuobaomingEntity> wrapper);

   	

}

