package com.heying.spring.autowire;

import com.heying.spring.old.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component//默认的id是tank
public class Tank implements Vehicle {
    @Value("中式")
    private String band;//品牌

@Value("黑色")
    private String color;//颜色

    @Value("100")
    private int price;//价格

    @Override
    public String toString() {
        return "Tank{" +
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

    public Tank() {
    }

    public Tank(String band, String color, int price) {
        this.band = band;
        this.color = color;
        this.price = price;
    }
    @Override
    public void run(){
        System.out.println(this.color+"的价值"+this.price+"万元的"
                +this.band+"坦克车正在行驶");
    }
}
