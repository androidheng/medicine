package com.medicine.vo;

import com.medicine.pojo.TbCart;

public class CartVo extends TbCart{
	    private String shopname;

	    private String price;


	    private String logo;
	    
	    private String sumPrice;
		public String getShopname() {
			return shopname;
		}

		public void setShopname(String shopname) {
			this.shopname = shopname;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}


		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		public String getSumPrice() {
			return sumPrice;
		}

		public void setSumPrice(String sumPrice) {
			this.sumPrice = sumPrice;
		}
	    
}
