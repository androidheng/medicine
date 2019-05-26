package com.medicine.service;
import java.util.List;

import com.medicine.pojo.TbCart;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface CartService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbCart> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbCart cart);
	
	
	/**
	 * 修改
	 */
	public void update(TbCart cart);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbCart findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer  id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbCart cart, int pageNum,int pageSize);


	public List<TbCart> findAll(Integer id);
	
	public List<TbCart> findAllUid(Integer uid,Integer sellerid);
	
}
