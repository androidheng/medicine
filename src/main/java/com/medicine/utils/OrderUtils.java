package com.medicine.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUtils {

	public static String getOrderNo() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		 String str = format.format(new Date()); 
		 return str;
	}
	public static String getCurrent() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 String str = format.format(new Date()); 
		 return str;
	}
}
