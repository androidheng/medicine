package com.medicine.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.medicine.pojo.TbCart;
import com.medicine.pojo.TbOrder;
import com.medicine.pojo.TbOrderdetail;
import com.medicine.pojo.TbSeller;
import com.medicine.pojo.TbShop;
import com.medicine.pojo.TbUser;
import com.medicine.service.CartService;
import com.medicine.service.OrderService;
import com.medicine.service.OrderdetailService;
import com.medicine.service.ShopService;
import com.medicine.utils.NumsUtils;
import com.medicine.utils.OrderUtils;
import com.medicine.vo.OrderDetailVo;
import com.medicine.vo.OrederVo;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderdetailService orderdetailService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ShopService shopService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbOrder> findAll(){			
		return orderService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return orderService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param order
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbOrder tbOrder,HttpSession session){
		try {
			TbUser user=(TbUser) session.getAttribute("user");
//			TbUser user=new TbUser();
//			user.setId(2);
			if(user!=null) {
				
				List<TbCart> list = cartService.findAll(user.getId());
				for (TbCart tbCart : list) {
					TbOrder order=new TbOrder();
					order.setReceiverman(tbOrder.getReceiverman());
					order.setReveiveraddress(tbOrder.getReveiveraddress());
					order.setReveiverphone(tbOrder.getReveiverphone());
					order.setUid(user.getId());
					order.setOrderno(OrderUtils.getOrderNo());
					order.setOrderamt(orderService.getSumPrice(user.getId()));
					System.out.println("订单金额:"+order.getOrderamt());
					order.setUid(user.getId());
					order.setSellerid(tbCart.getSellerid());
					order.setOrdertime(OrderUtils.getCurrent());
					order.setOrderstatus(0);
					orderService.add(order);
					
					System.out.println("订单id:"+order.getId());
					 List<TbCart> list2 = cartService.findAllUid(user.getId(), tbCart.getSellerid());
					 for (TbCart tbCart2 : list2) {
						 TbOrderdetail orderdetail=new TbOrderdetail();
							orderdetail.setOrderid(order.getId());
							orderdetail.setDetailcount(tbCart2.getShopcount());
							orderdetail.setShopid(tbCart2.getShopid());
							TbShop shop=shopService.findOne(tbCart2.getShopid());
							String detailprice=NumsUtils.getNums(Double.parseDouble(shop.getPrice())*tbCart2.getShopcount()+"");
							orderdetail.setDetailprice(detailprice);
							orderdetailService.add(orderdetail);
							cartService.delete(tbCart2.getId());
					}
				}
				return new Result(true, "下单成功");
			}else {
				return new Result(false, "请先登录");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param order
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbOrder order){
		try {
			orderService.update(order);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	@RequestMapping("/send")
	public Result send(@RequestBody TbOrder tbOrder){
		try {
			TbOrder order = orderService.findOne(tbOrder.getId());
			order.setOrderstatus(1);//发货
			orderService.update(order);
			return new Result(true, "发货成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "发货失败");
		}
	}
	@RequestMapping("/confirm")
	public Result confirm(@RequestBody TbOrder tbOrder){
		try {
			TbOrder order = orderService.findOne(tbOrder.getId());
			order.setOrderstatus(2);//确认收货
			orderService.update(order);
			return new Result(true, "收货成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "收货失败");
		}
	}
	@RequestMapping("/applyreturn")
	public Result applyreturn(@RequestBody TbOrder tbOrder){
		try {
			TbOrder order = orderService.findOne(tbOrder.getId());
			order.setOrderstatus(3);//申请退货
			orderService.update(order);
			return new Result(true, "申请成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "申请失败");
		}
	}
	@RequestMapping("/auditreturn")
	public Result auditreturn(@RequestBody TbOrder tbOrder){
		try {
			TbOrder order = orderService.findOne(tbOrder.getId());
			order.setOrderstatus(4);//退货成功
			orderService.update(order);
			return new Result(true, "退货成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "申请失败");
		}
	}
	@RequestMapping("/noauditreturn")
	public Result noauditreturn(@RequestBody TbOrder tbOrder){
		try {
			TbOrder order = orderService.findOne(tbOrder.getId());
			order.setOrderstatus(5);//退货不成功
			orderService.update(order);
			return new Result(true, "退货不成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "申请失败");
		}
	}
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbOrder findOne(@RequestBody TbOrder tbOrder){
		return orderService.findOne(tbOrder.getId());		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			orderService.delete(ids);
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
	public PageResult search(String key, int page, int limit ,HttpSession session ){
		TbSeller tbSeller=(TbSeller) session.getAttribute("seller");
		TbOrder order=new TbOrder();
			order.setOrderno(key);
			order.setSellerid(tbSeller.getId());
		return orderService.findPage(order, page, limit);		
	}
	@RequestMapping("/myorder")
	public Result myorder(HttpSession session){
		TbUser user=(TbUser) session.getAttribute("user");
//		TbUser user=new TbUser();
//		user.setId(2);
		if(user!=null) {
			List<TbOrder> orders=orderService.findMyOrder(user.getId());
			List<OrederVo> result=new ArrayList<>();
			
			for (TbOrder tbOrder : orders) {
				OrederVo orederVo=new OrederVo();
				BeanUtils.copyProperties(tbOrder, orederVo);
				if(tbOrder.getOrderstatus()==0) {
					orederVo.setStatus("未发货");
				}else if(tbOrder.getOrderstatus()==1) {
					orederVo.setStatus("已发货");
				}else if(tbOrder.getOrderstatus()==2) {
					orederVo.setStatus("确认收货");
				}else if(tbOrder.getOrderstatus()==3) {
					orederVo.setStatus("退货申请中");
				}else if(tbOrder.getOrderstatus()==4) {
					orederVo.setStatus("退货成功");
				}
				result.add(orederVo);
			}
			return new Result(true, result);
		}else {
			return new Result(false, "请先登录");
		}
	}
	/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/searchDetail")
	public List<OrderDetailVo> searchDetail(@RequestBody TbOrder order){
		List<OrderDetailVo> list=orderService.findByOrderId(order.getId());
		return list;		
	}
	@RequestMapping("/houSearchDetail")
	public PageResult houSearchDetail(int id, int page, int limit ){
		return orderService.findByHouOrderId(id,page,limit);
	}
	@RequestMapping("/houSearchExit")
	public PageResult houSearchExit(String key, int page, int limit ){
		TbOrder order=null;
		if(!StringUtils.isEmpty(key)){
			order=new TbOrder();
			order.setOrderno(key);
		}
		return orderService.findPage(order, page, limit);	
	}
	
}
