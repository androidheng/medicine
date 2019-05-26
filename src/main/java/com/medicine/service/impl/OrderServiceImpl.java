package com.medicine.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicine.mapper.TbOrderMapper;
import com.medicine.mapper.TbOrderdetailMapper;
import com.medicine.pojo.TbOrder;
import com.medicine.pojo.TbOrderExample;
import com.medicine.pojo.TbOrderExample.Criteria;
import com.medicine.service.OrderService;
import com.medicine.vo.OrderDetailVo;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper orderMapper;
	@Autowired
	private TbOrderdetailMapper orderdetailMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbOrder> findAll() {
		return orderMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbOrder> page=   (Page<TbOrder>) orderMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbOrder order) {
		orderMapper.insert(order);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbOrder order){
		orderMapper.updateByPrimaryKey(order);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbOrder findOne(Integer id){
		return orderMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			orderMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbOrder order, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbOrderExample example=new TbOrderExample();
		Criteria criteria = example.createCriteria();
		
		if(order!=null){	
			if(!StringUtils.isEmpty(order.getOrderno())) {
				criteria.andOrdernoLike("%"+order.getOrderno()+"%");
			}
			if(!StringUtils.isEmpty(order.getSellerid())) {
				criteria.andSelleridEqualTo(order.getSellerid());
			}
			
			
		}
		
		Page<TbOrder> page= (Page<TbOrder>)orderMapper.selectByExample(example);		
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<OrderDetailVo> findByOrderId(int id) {
			return orderdetailMapper.findByOrderId(id);
		}

		@Override
		public String getSumPrice(Integer id) {
			
			return orderdetailMapper.getSumPrice(id);
		}

		@Override
		public List<TbOrder> findMyOrder(Integer id) {
			TbOrderExample example=new TbOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andUidEqualTo(id);
			return orderMapper.selectByExample(example);
		}

		@Override
		public PageResult findByHouOrderId(Integer id, int pageNum, int pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			
			Page<OrderDetailVo> page= (Page<OrderDetailVo>)orderdetailMapper.findByOrderId(id);	
//			return new PageResult(page.getTotal(), page.getResult());
			return new PageResult(0,"",page.getTotal(), page.getResult());
		}
	
}
