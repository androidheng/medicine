package com.medicine.pojo;

public class TbOrder {
    private Integer id;

    private String orderno;

    private String ordertime;

    private String orderamt;

    private String receiverman;

    private String reveiverphone;

    private String reveiveraddress;

    private Integer uid;

    private Integer sellerid;

    private Integer orderstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public String getOrderamt() {
        return orderamt;
    }

    public void setOrderamt(String orderamt) {
        this.orderamt = orderamt == null ? null : orderamt.trim();
    }

    public String getReceiverman() {
        return receiverman;
    }

    public void setReceiverman(String receiverman) {
        this.receiverman = receiverman == null ? null : receiverman.trim();
    }

    public String getReveiverphone() {
        return reveiverphone;
    }

    public void setReveiverphone(String reveiverphone) {
        this.reveiverphone = reveiverphone == null ? null : reveiverphone.trim();
    }

    public String getReveiveraddress() {
        return reveiveraddress;
    }

    public void setReveiveraddress(String reveiveraddress) {
        this.reveiveraddress = reveiveraddress == null ? null : reveiveraddress.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSellerid() {
        return sellerid;
    }

    public void setSellerid(Integer sellerid) {
        this.sellerid = sellerid;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }
}