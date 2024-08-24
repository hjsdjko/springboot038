package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiangzuobaomingDao;
import com.entity.JiangzuobaomingEntity;
import com.service.JiangzuobaomingService;
import com.entity.vo.JiangzuobaomingVO;
import com.entity.view.JiangzuobaomingView;

@Service("jiangzuobaomingService")
public class JiangzuobaomingServiceImpl extends ServiceImpl<JiangzuobaomingDao, JiangzuobaomingEntity> implements JiangzuobaomingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiangzuobaomingEntity> page = this.selectPage(
                new Query<JiangzuobaomingEntity>(params).getPage(),
                new EntityWrapper<JiangzuobaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiangzuobaomingEntity> wrapper) {
		  Page<JiangzuobaomingView> page =new Query<JiangzuobaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiangzuobaomingVO> selectListVO(Wrapper<JiangzuobaomingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiangzuobaomingVO selectVO(Wrapper<JiangzuobaomingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiangzuobaomingView> selectListView(Wrapper<JiangzuobaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiangzuobaomingView selectView(Wrapper<JiangzuobaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
