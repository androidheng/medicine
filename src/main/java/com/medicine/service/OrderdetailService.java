package com.medicine.service;
import java.util.List;

import com.medicine.pojo.TbOrder;
import com.medicine.pojo.TbOrderdetail;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface OrderdetailService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbOrderdetail> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbOrderdetail orderdetail);
	
	
	/**
	 * 修改
	 */
	public void update(TbOrderdetail orderdetail);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbOrderdetail findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbOrderdetail orderdetail, int pageNum,int pageSize);
	
	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbOrderdetail> findAllByOrderId(int orderid);


	
	
}
