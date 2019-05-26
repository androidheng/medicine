package com.medicine.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicine.mapper.TbSellerMapper;
import com.medicine.pojo.TbSeller;
import com.medicine.pojo.TbSellerExample;
import com.medicine.pojo.TbSellerExample.Criteria;
import com.medicine.service.SellerService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private TbSellerMapper sellerMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSeller> findAll() {
		return sellerMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSeller> page=   (Page<TbSeller>) sellerMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSeller seller) {
		sellerMapper.insert(seller);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbSeller seller){
		sellerMapper.updateByPrimaryKey(seller);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbSeller findOne(Integer id){
		return sellerMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			sellerMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSellerExample example=new TbSellerExample();
		Criteria criteria = example.createCriteria();
		
		if(seller!=null){			
			if(seller.getStatu()!=null) {
				criteria.andStatuEqualTo(seller.getStatu());
			}	
		}
		
		Page<TbSeller> page= (Page<TbSeller>)sellerMapper.selectByExample(example);		
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public TbSeller login(String username, String password) {
			TbSellerExample example=new TbSellerExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(username);
			criteria.andPasswordEqualTo(password);
			List<TbSeller> list = sellerMapper.selectByExample(example);
			if(list.size()>0)
				return list.get(0);
			return null;
		}
	
}
