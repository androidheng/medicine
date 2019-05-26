package com.medicine.vo;

import com.medicine.pojo.TbOrderdetail;

public class OrderDetailVo extends TbOrderdetail{
		private String shopname;

	    private String logo;
	    
	    private String sumprice;

		public String getShopname() {
			return shopname;
		}

		public void setShopname(String shopname) {
			this.shopname = shopname;
		}

		public String getLogo() {
			return logo;
		}

		public void setLogo(String logo) {
			this.logo = logo;
		}

		public String getSumprice() {
			return sumprice;
		}

		public void setSumprice(String sumprice) {
			this.sumprice = sumprice;
		}

	    
}
