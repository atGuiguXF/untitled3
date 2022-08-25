package com.heying.spring.autowire;

import com.heying.spring.old.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")//默认car 不写也行
public class Car implements Vehicle {
    @Value("奔驰")
    private String band;//品牌

    @Value("红色")
    private String color;//颜色

    @Value("30")
    private int price;//价格

    @Override
    public String toString() {
        return "Car{" +
                "band='" + band + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car() {
    }

    public Car(String band, String color, int price) {
        this.band = band;
        this.color = color;
        this.price = price;
    }

    @Override
    public void run(){
        System.out.println(this.color+"的价值"+this.price+"万元的"
        +this.band+"汽车正在行驶");
    }
}
