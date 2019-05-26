package com.medicine.pojo;

public class TbOrderdetail {
    private Integer id;

    private Integer shopid;

    private Integer detailcount;

    private String detailprice;

    private Integer orderid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getDetailcount() {
        return detailcount;
    }

    public void setDetailcount(Integer detailcount) {
        this.detailcount = detailcount;
    }

    public String getDetailprice() {
        return detailprice;
    }

    public void setDetailprice(String detailprice) {
        this.detailprice = detailprice == null ? null : detailprice.trim();
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}