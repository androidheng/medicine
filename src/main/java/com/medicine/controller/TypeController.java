package com.medicine.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.medicine.pojo.TbType;
import com.medicine.service.TypeService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbType> findAll(){			
		return typeService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return typeService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param type
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbType type){
		try {
			typeService.add(type);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param type
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbType type){
		try {
			typeService.update(type);
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
	public TbType findOne(Integer id){
		return typeService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			typeService.delete(ids);
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
	public PageResult search(String key, int page, int limit  ){
		TbType type=null;
		if(!StringUtils.isEmpty(key)) {
			type=new TbType();
			type.setTypename(key);
		}
		return typeService.findPage(type, page, limit);		
	}
	
}
