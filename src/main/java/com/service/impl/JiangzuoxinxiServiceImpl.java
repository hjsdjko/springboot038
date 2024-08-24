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


import com.dao.JiangzuoxinxiDao;
import com.entity.JiangzuoxinxiEntity;
import com.service.JiangzuoxinxiService;
import com.entity.vo.JiangzuoxinxiVO;
import com.entity.view.JiangzuoxinxiView;

@Service("jiangzuoxinxiService")
public class JiangzuoxinxiServiceImpl extends ServiceImpl<JiangzuoxinxiDao, JiangzuoxinxiEntity> implements JiangzuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiangzuoxinxiEntity> page = this.selectPage(
                new Query<JiangzuoxinxiEntity>(params).getPage(),
                new EntityWrapper<JiangzuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiangzuoxinxiEntity> wrapper) {
		  Page<JiangzuoxinxiView> page =new Query<JiangzuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiangzuoxinxiVO> selectListVO(Wrapper<JiangzuoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiangzuoxinxiVO selectVO(Wrapper<JiangzuoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiangzuoxinxiView> selectListView(Wrapper<JiangzuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiangzuoxinxiView selectView(Wrapper<JiangzuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
