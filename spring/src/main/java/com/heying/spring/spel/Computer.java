package com.heying.spring.spel;

public class Computer {
    private String band;

    private int price;

    public Computer(String band, int price) {
        this.band = band;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "band='" + band + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
