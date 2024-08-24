package com.dao;

import com.entity.JiangzuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiangzuoxinxiVO;
import com.entity.view.JiangzuoxinxiView;


/**
 * 讲座信息
 * 
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public interface JiangzuoxinxiDao extends BaseMapper<JiangzuoxinxiEntity> {
	
	List<JiangzuoxinxiVO> selectListVO(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
	
	JiangzuoxinxiVO selectVO(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
	
	List<JiangzuoxinxiView> selectListView(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);

	List<JiangzuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);

	
	JiangzuoxinxiView selectView(@Param("ew") Wrapper<JiangzuoxinxiEntity> wrapper);
	

}
