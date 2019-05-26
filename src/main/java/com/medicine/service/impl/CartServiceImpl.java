package com.medicine.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicine.mapper.TbCartMapper;
import com.medicine.pojo.TbCart;
import com.medicine.pojo.TbCartExample;
import com.medicine.pojo.TbCartExample.Criteria;
import com.medicine.service.CartService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private TbCartMapper cartMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbCart> findAll() {
		return cartMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbCart> page=   (Page<TbCart>) cartMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbCart cart) {
		cartMapper.insert(cart);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbCart cart){
		cartMapper.updateByPrimaryKey(cart);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbCart findOne(Integer id){
		return cartMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer id) {
		cartMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbCart cart, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCartExample example=new TbCartExample();
		Criteria criteria = example.createCriteria();
		
		if(cart!=null){			
				
		}
		
		Page<TbCart> page= (Page<TbCart>)cartMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbCart> findAll(Integer id) {
			
			return cartMapper.findAllByUid(id);	
		}

		@Override
		public List<TbCart> findAllUid(Integer uid,Integer sellerid) {
			TbCartExample example=new TbCartExample();
			Criteria criteria = example.createCriteria();
			criteria.andSelleridEqualTo(sellerid);
			criteria.andUidEqualTo(uid);
			
				
			return cartMapper.selectByExample(example);
		}
	
}
