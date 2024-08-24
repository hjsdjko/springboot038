package com.dao;

import com.entity.DiscusszhishikepuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhishikepuVO;
import com.entity.view.DiscusszhishikepuView;


/**
 * 知识科普评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-21 23:22:12
 */
public interface DiscusszhishikepuDao extends BaseMapper<DiscusszhishikepuEntity> {
	
	List<DiscusszhishikepuVO> selectListVO(@Param("ew") Wrapper<DiscusszhishikepuEntity> wrapper);
	
	DiscusszhishikepuVO selectVO(@Param("ew") Wrapper<DiscusszhishikepuEntity> wrapper);
	
	List<DiscusszhishikepuView> selectListView(@Param("ew") Wrapper<DiscusszhishikepuEntity> wrapper);

	List<DiscusszhishikepuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhishikepuEntity> wrapper);

	
	DiscusszhishikepuView selectView(@Param("ew") Wrapper<DiscusszhishikepuEntity> wrapper);
	

}
