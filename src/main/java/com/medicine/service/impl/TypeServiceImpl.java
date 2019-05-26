package com.medicine.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicine.mapper.TbTypeMapper;
import com.medicine.pojo.TbType;
import com.medicine.pojo.TbTypeExample;
import com.medicine.pojo.TbTypeExample.Criteria;
import com.medicine.service.TypeService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TbTypeMapper typeMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbType> findAll() {
		return typeMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbType> page=   (Page<TbType>) typeMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbType type) {
		typeMapper.insert(type);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbType type){
		typeMapper.updateByPrimaryKey(type);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbType findOne(Integer id){
		return typeMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			typeMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbType type, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTypeExample example=new TbTypeExample();
		Criteria criteria = example.createCriteria();
		
		if(type!=null){			
				
		}
		
		Page<TbType> page= (Page<TbType>)typeMapper.selectByExample(example);		
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
