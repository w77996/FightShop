package com.qst.entity;



/**
 * Created by Administrator on 2016/10/27.
 */
public class OrderDetailItemBean {
    public String itemDate;
    public String itemDetail;
    public String itemPrice;

    public OrderDetailItemBean(String itemDate, String itemDetail, String itemPrice) {
        this.itemDate = itemDate;
        this.itemDetail = itemDetail;
        this.itemPrice = itemPrice;
    }
}
