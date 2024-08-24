package com.dao;

import com.entity.JiangzuobaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiangzuobaomingVO;
import com.entity.view.JiangzuobaomingView;


/**
 * 讲座报名
 * 
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public interface JiangzuobaomingDao extends BaseMapper<JiangzuobaomingEntity> {
	
	List<JiangzuobaomingVO> selectListVO(@Param("ew") Wrapper<JiangzuobaomingEntity> wrapper);
	
	JiangzuobaomingVO selectVO(@Param("ew") Wrapper<JiangzuobaomingEntity> wrapper);
	
	List<JiangzuobaomingView> selectListView(@Param("ew") Wrapper<JiangzuobaomingEntity> wrapper);

	List<JiangzuobaomingView> selectListView(Pagination page,@Param("ew") Wrapper<JiangzuobaomingEntity> wrapper);

	
	JiangzuobaomingView selectView(@Param("ew") Wrapper<JiangzuobaomingEntity> wrapper);
	

}
