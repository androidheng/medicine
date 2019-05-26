package com.medicine.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.medicine.pojo.TbOrderdetail;
import com.medicine.service.OrderdetailService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/orderdetail")
public class OrderdetailController {

	@Autowired
	private OrderdetailService orderdetailService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbOrderdetail> findAll(){			
		return orderdetailService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return orderdetailService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param orderdetail
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbOrderdetail orderdetail){
		try {
			orderdetailService.add(orderdetail);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param orderdetail
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbOrderdetail orderdetail){
		try {
			orderdetailService.update(orderdetail);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbOrderdetail findOne(Integer id){
		return orderdetailService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			orderdetailService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbOrderdetail orderdetail, int page, int rows  ){
		return orderdetailService.findPage(orderdetail, page, rows);		
	}
	
}
