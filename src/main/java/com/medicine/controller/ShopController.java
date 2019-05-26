package com.medicine.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.medicine.pojo.TbSeller;
import com.medicine.pojo.TbShop;
import com.medicine.service.ShopService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbShop> findAll(){			
		return shopService.findAll();
	}
	@RequestMapping("/detail")
	public String detail(Integer id,Model model){	
		System.out.println(id);
		 TbShop shop = shopService.findOne(id);
		 model.addAttribute("shop", shop);
		 return "product-details";
	}
	
	@ResponseBody
	@RequestMapping("/findByType")
	public List<TbShop> findByType(int type){			
		return shopService.findByType(type);
	}
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return shopService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param shop
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbShop shop,HttpSession session){
		TbSeller seller=(TbSeller) session.getAttribute("seller");
		if(seller!=null) {
			if(StringUtils.isEmpty(shop.getId())) {
				try {
					System.out.println("添加");
					shop.setSellerid(seller.getId());
					shopService.add(shop);
					return new Result(true, "增加成功");
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(false, "增加失败");
				}
			}else {
				try {
					System.out.println("修改");
					System.out.println(shop.getDescription());
					shopService.update(shop);
					return new Result(true, "修改成功");
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(false, "修改失败");
				}
			}
		}else {
			return new Result(false, "请先登录");
		}
		
		
	}
	
	/**
	 * 修改
	 * @param shop
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbShop shop){
		try {
			shopService.update(shop);
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
	@ResponseBody
	@RequestMapping("/findOne")
	public TbShop findOne(Integer id,@RequestBody TbShop shop){
		System.out.println("id"+shop.getId());
		return shopService.findOne(8);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestParam String  id){
		try {
			System.out.println(id+"");
			shopService.delete(Integer.parseInt(id));
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	@ResponseBody
	@RequestMapping("/updatestatus")
	public Result updateStatus(@RequestParam String  shopstatus,@RequestParam String id){
		try {
			
			TbShop shop=new TbShop();
			shop.setId(Integer.parseInt(id));
			shop.setShopstatus(shopstatus);
			shopService.update(shop);
			if("on".equals(shopstatus)) {
				return new Result(true, "上架成功"); 
			}else {
				return new Result(true, "下架成功"); 
			}
			
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
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key, int page, int limit ,HttpSession session ){
		TbSeller tbSeller=(TbSeller) session.getAttribute("seller");
		TbShop shop=new TbShop();
		shop.setShopname(key);
		shop.setSellerid(tbSeller.getId());
		return shopService.findPage(shop, page, limit);		
	}
	@ResponseBody
	@RequestMapping("/shousearch")
	public List<TbShop> shousearch(String key){
		TbShop shop=null;
		if(!StringUtils.isEmpty(key)){
			shop=new TbShop();
			shop.setShopname(key);
		}
		return shopService.findPage(shop);		
	}
	
	@ResponseBody
	@RequestMapping("/hotShop")
	public List<TbShop> hotShop(){
		return shopService.hotShop();			
	}
	
	@ResponseBody
	@RequestMapping("/sellerShop")
	public List<TbShop> sellerShop(@RequestBody TbShop shop,HttpServletRequest request){
		return shopService.sellerShop(shop.getSellerid());			
	}
	@ResponseBody
	@RequestMapping("/upload")
	public Result upload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session){
	    if (file!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath=request.getSession().getServletContext().getRealPath("uploadfile/");
                    // 自定义的文件名称
                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName.substring(fileName.indexOf("."));
                    // 设置存放图片文件的路径
                    path=realPath+File.separator+trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径
                    try {
						file.transferTo(new File(path));
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    System.out.println("文件成功上传到指定目录下");
                    return new Result(true, trueFileName);
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return null;
                }
            }else {
                System.out.println("文件类型为空");
                return null;
            }
        }else {
            System.out.println("没有找到相对应的文件");
            return null;
        }
	}
	
}
