package com.medicine.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicine.mapper.TbOrderdetailMapper;
import com.medicine.pojo.TbOrder;
import com.medicine.pojo.TbOrderdetail;
import com.medicine.pojo.TbOrderdetailExample;
import com.medicine.pojo.TbOrderdetailExample.Criteria;
import com.medicine.service.OrderdetailService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class OrderdetailServiceImpl implements OrderdetailService {

	@Autowired
	private TbOrderdetailMapper orderdetailMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbOrderdetail> findAll() {
		return orderdetailMapper.selectByExample(null);
		
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbOrderdetail> page=   (Page<TbOrderdetail>) orderdetailMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbOrderdetail orderdetail) {
		orderdetailMapper.insert(orderdetail);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbOrderdetail orderdetail){
		orderdetailMapper.updateByPrimaryKey(orderdetail);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbOrderdetail findOne(Integer id){
		return orderdetailMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			orderdetailMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbOrderdetail orderdetail, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbOrderdetailExample example=new TbOrderdetailExample();
		Criteria criteria = example.createCriteria();
		
		if(orderdetail!=null){			
				
		}
		
		Page<TbOrderdetail> page= (Page<TbOrderdetail>)orderdetailMapper.selectByExample(example);		
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbOrderdetail> findAllByOrderId(int orderid) {
			// TODO Auto-generated method stub
			return null;
		}

	
}
