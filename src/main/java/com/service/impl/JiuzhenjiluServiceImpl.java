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


import com.dao.JiuzhenjiluDao;
import com.entity.JiuzhenjiluEntity;
import com.service.JiuzhenjiluService;
import com.entity.vo.JiuzhenjiluVO;
import com.entity.view.JiuzhenjiluView;

@Service("jiuzhenjiluService")
public class JiuzhenjiluServiceImpl extends ServiceImpl<JiuzhenjiluDao, JiuzhenjiluEntity> implements JiuzhenjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuzhenjiluEntity> page = this.selectPage(
                new Query<JiuzhenjiluEntity>(params).getPage(),
                new EntityWrapper<JiuzhenjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuzhenjiluEntity> wrapper) {
		  Page<JiuzhenjiluView> page =new Query<JiuzhenjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiuzhenjiluVO> selectListVO(Wrapper<JiuzhenjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiuzhenjiluVO selectVO(Wrapper<JiuzhenjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiuzhenjiluView> selectListView(Wrapper<JiuzhenjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuzhenjiluView selectView(Wrapper<JiuzhenjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<JiuzhenjiluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<JiuzhenjiluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<JiuzhenjiluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
