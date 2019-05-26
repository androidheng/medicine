package com.medicine.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.medicine.pojo.TbCart;
import com.medicine.pojo.TbSeller;
import com.medicine.pojo.TbShop;
import com.medicine.pojo.TbUser;
import com.medicine.service.CartService;
import com.medicine.service.SellerService;
import com.medicine.service.ShopService;
import com.medicine.utils.NumsUtils;
import com.medicine.vo.CartVo;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private SellerService sellerService;
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbCart> findAll(){			
		return cartService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return cartService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param cart
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbCart cart,HttpSession session){
		try {
			TbUser user=(TbUser) session.getAttribute("user");
//			TbUser user=new TbUser();
//			user.setId(2);
			if(user!=null){
				cart.setUid(user.getId());
				TbShop shop = shopService.findOne(cart.getShopid());
				cart.setSellerid(shop.getSellerid());
				cartService.add(cart);
				return new Result(true, "添加成功");
			}else{
				return new Result(false, "请先登录");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param cart
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbCart cart){
		try {
			cartService.update(cart);
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
	public TbCart findOne(Integer id){
		return cartService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbCart cart){
		try {
			cartService.delete(cart.getId());
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
	public Result search(HttpSession session ){
//		TbUser user=(TbUser) session.getAttribute("user");
		TbUser user=new TbUser();
		user.setId(2);
		if(user!=null){
			
			 List<TbCart> list = cartService.findAll(user.getId());
			 System.out.println(list.size());
			 List<Map<String, Object>> mapList=new ArrayList<>();
			 for(TbCart cart:list){
				 Map<String, Object> map=new HashMap<String, Object>();
				 TbSeller seller = sellerService.findOne(cart.getSellerid());
				 map.put("shopname", seller.getShopname());
				 List<TbCart> list2 = cartService.findAllUid(user.getId(), cart.getSellerid());
				 List<CartVo> result=new ArrayList<CartVo>();
				 for (TbCart tbCart : list2) {
					 CartVo cartVo=new CartVo();
					 TbShop shop = shopService.findOne(tbCart.getShopid());
					 cartVo.setId(tbCart.getId());
					 cartVo.setShopid(shop.getId());
					 cartVo.setShopcount(tbCart.getShopcount());
					 cartVo.setLogo(shop.getLogo());
					 cartVo.setShopname(shop.getShopname());
					 cartVo.setPrice(shop.getPrice());
					 String sumPrice=NumsUtils.getNums((Double.parseDouble(shop.getPrice())*tbCart.getShopcount()+""));
					 cartVo.setSumPrice(sumPrice);
					 result.add(cartVo);
				}
				 map.put("productList", result);
				 mapList.add(map);
			 }
			return new Result(true, mapList);
		}else{
			return new Result(false, "请先登录");
		}
			
	}
	
}
