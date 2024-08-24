package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YishengpaibanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YishengpaibanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YishengpaibanView;


/**
 * 医生排班
 *
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
public interface YishengpaibanService extends IService<YishengpaibanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YishengpaibanVO> selectListVO(Wrapper<YishengpaibanEntity> wrapper);
   	
   	YishengpaibanVO selectVO(@Param("ew") Wrapper<YishengpaibanEntity> wrapper);
   	
   	List<YishengpaibanView> selectListView(Wrapper<YishengpaibanEntity> wrapper);
   	
   	YishengpaibanView selectView(@Param("ew") Wrapper<YishengpaibanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YishengpaibanEntity> wrapper);

   	

}

