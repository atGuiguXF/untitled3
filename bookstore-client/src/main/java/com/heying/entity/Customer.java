package com.heying.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private Integer customer;
    private String customer_name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Integer referred;

    public Customer() {
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getReferred() {
        return referred;
    }

    public void setReferred(Integer referred) {
        this.referred = referred;
    }

    public Customer(Integer customer, String customer_name, String address, String city, String state, String zip, Integer referred) {
        this.customer = customer;
        this.customer_name = customer_name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.referred = referred;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer=" + customer +
                ", customer_name='" + customer_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", referred=" + referred +
                '}';
    }
}
