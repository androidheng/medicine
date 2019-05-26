package com.medicine.utils;

import java.math.BigDecimal;

public class NumsUtils {
    public static String getNums(String nums){
        BigDecimal bigDecimal=new BigDecimal(nums);
        BigDecimal newBigDecimal=bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return newBigDecimal.toString();
    }
}
