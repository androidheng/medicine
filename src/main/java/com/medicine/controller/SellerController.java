package com.medicine.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.medicine.pojo.TbSeller;
import com.medicine.service.SellerService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSeller> findAll(){			
		return sellerService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return sellerService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param seller
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbSeller seller){
		try {
			seller.setStatu(0);
			sellerService.add(seller);
			return new Result(true, "注册成功,请等待审核");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param seller
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbSeller seller){
		try {
			sellerService.update(seller);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	@RequestMapping("/audit")
	public Result audit(@RequestBody TbSeller tbSeller){
		try {
			TbSeller seller = sellerService.findOne(tbSeller.getId());
			seller.setStatu(1);//审核通过
			sellerService.update(seller);
			return new Result(true, "审核成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "审核失败");
		}
	}	
	@RequestMapping("/noaudit")
	public Result noaudit(@RequestBody TbSeller tbSeller){
		try {
			TbSeller seller = sellerService.findOne(tbSeller.getId());
			seller.setStatu(2);//审核不通过
			sellerService.update(seller);
			return new Result(true, "审核成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "审核失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbSeller findOne(Integer id){
		return sellerService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			sellerService.delete(ids);
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
	public PageResult search(@RequestBody TbSeller seller, int page, int limit  ){
		return sellerService.findPage(seller, page, limit);		
	}
	@RequestMapping("/searchno")
	public PageResult searchno(int page, int limit  ){
		TbSeller seller=new TbSeller();
		seller.setStatu(0);
		return sellerService.findPage(seller, page, limit);		
	}
	
	@RequestMapping("/login")
	public Result login(@RequestBody TbSeller seller,HttpSession session){
		try {
			System.out.println("username:"+seller.getUsername());
			System.out.println("password:"+seller.getPassword());
			TbSeller loginSeller=sellerService.login(seller.getUsername(),seller.getPassword());
			if(loginSeller!=null) {
				if(loginSeller.getStatu()==0) {
					return new Result(false, "还未审核");
				}else {
					session.setAttribute("seller", loginSeller);
					return new Result(true, "登录成功");
				}
			}
			return new Result(false, "不存在此账户");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
}
