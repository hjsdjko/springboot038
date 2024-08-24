package com.dao;

import com.entity.DiscussjiangzuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiangzuoxinxiVO;
import com.entity.view.DiscussjiangzuoxinxiView;


/**
 * 讲座信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public interface DiscussjiangzuoxinxiDao extends BaseMapper<DiscussjiangzuoxinxiEntity> {
	
	List<DiscussjiangzuoxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
	
	DiscussjiangzuoxinxiVO selectVO(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
	
	List<DiscussjiangzuoxinxiView> selectListView(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);

	List<DiscussjiangzuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);

	
	DiscussjiangzuoxinxiView selectView(@Param("ew") Wrapper<DiscussjiangzuoxinxiEntity> wrapper);
	

}
