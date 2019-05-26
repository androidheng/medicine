package com.medicine.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.medicine.mapper.TbShopMapper;
import com.medicine.pojo.TbShop;
import com.medicine.pojo.TbShopExample;
import com.medicine.pojo.TbShopExample.Criteria;
import com.medicine.service.ShopService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private TbShopMapper shopMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbShop> findAll() {
		return shopMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbShop> page=   (Page<TbShop>) shopMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbShop shop) {
		shopMapper.insert(shop);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbShop shop){
		shopMapper.updateByPrimaryKeySelective(shop);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbShop findOne(Integer id){
		return shopMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer id) {
		shopMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbShop shop, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbShopExample example=new TbShopExample();
		Criteria criteria = example.createCriteria();
		
		if(shop!=null){		
			if(!StringUtils.isEmpty(shop.getShopname())) {
				criteria.andShopnameLike("%"+shop.getShopname()+"%");
			}
			if(!StringUtils.isEmpty(shop.getSellerid())) {
				criteria.andSelleridEqualTo(shop.getSellerid());
			}
			
		}
		
		Page<TbShop> page= (Page<TbShop>)shopMapper.selectByExampleWithBLOBs(example);		
//		return new PageResult(page.getTotal(), page.getResult());
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbShop> findByType(int type) {
			TbShopExample example=new TbShopExample();
			Criteria criteria = example.createCriteria();
			criteria.andTypeidEqualTo(type);
			return shopMapper.selectByExampleWithBLOBs(example);
		}

		@Override
		public List<TbShop> findPage(TbShop shop) {
			TbShopExample example=new TbShopExample();
			Criteria criteria = example.createCriteria();
			
			if(shop!=null){			
				criteria.andShopnameLike("%"+shop.getShopname()+"%");
			}
			return shopMapper.selectByExampleWithBLOBs(example);
		}

		@Override
		public List<TbShop> hotShop() {
//			PageHelper.startPage(1, 5);
			
			TbShopExample example=new TbShopExample();
			Criteria criteria = example.createCriteria();
			
			return shopMapper.selectByExampleWithBLOBs(example);		
		}

		@Override
		public List<TbShop> sellerShop(Integer sellerid) {
			TbShopExample example=new TbShopExample();
			Criteria criteria = example.createCriteria();
			criteria.andSelleridEqualTo(sellerid);
			return shopMapper.selectByExampleWithBLOBs(example);	
		}
	
}
