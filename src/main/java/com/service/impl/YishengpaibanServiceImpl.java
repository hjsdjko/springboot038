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


import com.dao.YishengpaibanDao;
import com.entity.YishengpaibanEntity;
import com.service.YishengpaibanService;
import com.entity.vo.YishengpaibanVO;
import com.entity.view.YishengpaibanView;

@Service("yishengpaibanService")
public class YishengpaibanServiceImpl extends ServiceImpl<YishengpaibanDao, YishengpaibanEntity> implements YishengpaibanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YishengpaibanEntity> page = this.selectPage(
                new Query<YishengpaibanEntity>(params).getPage(),
                new EntityWrapper<YishengpaibanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YishengpaibanEntity> wrapper) {
		  Page<YishengpaibanView> page =new Query<YishengpaibanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YishengpaibanVO> selectListVO(Wrapper<YishengpaibanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YishengpaibanVO selectVO(Wrapper<YishengpaibanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YishengpaibanView> selectListView(Wrapper<YishengpaibanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YishengpaibanView selectView(Wrapper<YishengpaibanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
