package com.medicine.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.medicine.pojo.TbUser;
import com.medicine.service.UserService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbUser> findAll(){			
		return userService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int limit){			
		return userService.findPage(page, limit);
	}
	
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbUser user){
		try {
			userService.add(user);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbUser user){
		try {
			userService.update(user);
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
	public TbUser findOne(Integer id){
		return userService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			userService.delete(ids);
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
	public PageResult search(@RequestBody TbUser user, int page, int limit  ){
		return userService.findPage(user, page, limit);		
	}
	/**
	 * 登录
	 * @param username password
	 * @return
	 */
	@RequestMapping("/login")
	public Result login(@RequestBody TbUser user,HttpSession session){
		try {
			System.out.println("用户名:"+user.getUsername());
			System.out.println("密码:"+user.getPassword());
			TbUser loginUser=userService.login(user);
			if(loginUser!=null){
				session.setAttribute("user", loginUser);
			    return new Result(true, "登录成功"); 
			}
			return new Result(false, "登录失败"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	@RequestMapping("/register")
	public Result register(@RequestBody TbUser user,HttpSession session){
		try {
			System.out.println("用户名:"+user.getUsername());
			System.out.println("密码:"+user.getPassword());
			userService.add(user);
			return new Result(true, "注册成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "注册失败");
		}
	}
	@RequestMapping("/loginOut")
	public Result loginOut(HttpSession session){
		try {
			session.removeAttribute("user");
			return new Result(true, "退出成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "退出失败");
		}
	}
}
