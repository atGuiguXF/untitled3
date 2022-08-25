package com.heying.spring.old;

/**
 * 类和类之间哪些关系 继承关系 依赖关系
 * */
public class Story {
    public static void main(String[] args) {
        final Vehicle car = new Car("奔驰", "红色", 30);
        final Driver driver = new Driver("王师傅", 50);
        driver.drive(car);

        final Vehicle tank = new Tank("中式", "橄榄绿", 50);
        driver.drive(tank);
        final Vehicle trunk = new Trunk("东风", "蓝色", 10);
        driver.drive(trunk);

    }
}
