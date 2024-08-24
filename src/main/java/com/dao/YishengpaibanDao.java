package com.dao;

import com.entity.YishengpaibanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YishengpaibanVO;
import com.entity.view.YishengpaibanView;


/**
 * 医生排班
 * 
 * @author 
 * @email 
 * @date 2024-04-21 23:22:11
 */
public interface YishengpaibanDao extends BaseMapper<YishengpaibanEntity> {
	
	List<YishengpaibanVO> selectListVO(@Param("ew") Wrapper<YishengpaibanEntity> wrapper);
	
	YishengpaibanVO selectVO(@Param("ew") Wrapper<YishengpaibanEntity> wrapper);
	
	List<YishengpaibanView> selectListView(@Param("ew") Wrapper<YishengpaibanEntity> wrapper);

	List<YishengpaibanView> selectListView(Pagination page,@Param("ew") Wrapper<YishengpaibanEntity> wrapper);

	
	YishengpaibanView selectView(@Param("ew") Wrapper<YishengpaibanEntity> wrapper);
	

}
