package com.dao;

import com.entity.JiuzhenjiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiuzhenjiluVO;
import com.entity.view.JiuzhenjiluView;


/**
 * 就诊记录
 * 
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
public interface JiuzhenjiluDao extends BaseMapper<JiuzhenjiluEntity> {
	
	List<JiuzhenjiluVO> selectListVO(@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);
	
	JiuzhenjiluVO selectVO(@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);
	
	List<JiuzhenjiluView> selectListView(@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);

	List<JiuzhenjiluView> selectListView(Pagination page,@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);

	
	JiuzhenjiluView selectView(@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiuzhenjiluEntity> wrapper);



}
