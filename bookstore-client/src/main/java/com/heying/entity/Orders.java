package com.heying.entity;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {//三板斧+无参构造器
    private Integer orderno;
    private Integer customer;
    private Date orderdate;
    private Date shipdate;
    private String shipstreet;
    private String shipcity;
    private String shipstate;
    private String shipzip;

    @Override
    public String toString() {
        return "Orders{" +
                "orderno=" + orderno +
                ", customer=" + customer +
                ", orderdate=" + orderdate +
                ", shipdate=" + shipdate +
                ", shipstreet='" + shipstreet + '\'' +
                ", shipcity='" + shipcity + '\'' +
                ", shipstate='" + shipstate + '\'' +
                ", shipzip='" + shipzip + '\'' +
                '}';
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public String getShipstreet() {
        return shipstreet;
    }

    public void setShipstreet(String shipstreet) {
        this.shipstreet = shipstreet;
    }

    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity;
    }

    public String getShipstate() {
        return shipstate;
    }

    public void setShipstate(String shipstate) {
        this.shipstate = shipstate;
    }

    public String getShipzip() {
        return shipzip;
    }

    public void setShipzip(String shipzip) {
        this.shipzip = shipzip;
    }

    public Orders() {
    }

    public Orders(Integer orderno, Integer customer, Date orderdate, Date shipdate, String shipstreet, String shipcity, String shipstate, String shipzip) {
        this.orderno = orderno;
        this.customer = customer;
        this.orderdate = orderdate;
        this.shipdate = shipdate;
        this.shipstreet = shipstreet;
        this.shipcity = shipcity;
        this.shipstate = shipstate;
        this.shipzip = shipzip;
    }
}
