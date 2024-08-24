package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiangzuoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiangzuoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiangzuoxinxiView;


/**
 * 讲座信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public interface DiscussjiangzuoxinxiService extends IService<DiscussjiangzuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiangzuoxinxiVO> selectListVO(Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
   	
   	DiscussjiangzuoxinxiVO selectVO(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
   	
   	List<DiscussjiangzuoxinxiView> selectListView(Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
   	
   	DiscussjiangzuoxinxiView selectView(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiangzuoxinxiEntity> wrapper);

   	

}

