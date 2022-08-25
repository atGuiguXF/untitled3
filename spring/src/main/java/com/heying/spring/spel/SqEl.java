package com.heying.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component//加组件注释
public class SqEl {
    @Value("#{666}")
    private int num;

    @Value("#{T(Math).PI}")
    private double pi;

    @Value("#{person.name}")
    private String personName;
    @Value("#{person.sex}")
    private String personSex;
    @Value("#{T(Math).random()}")
    private double random;

    @Value("#{'${list}'.split(',')}")
    private List<String> list;

    @Value("#{${map}}")
    private Map<String,String> map;

    @Value("#{person.computerList.^[band eq '红米']}")
    private Computer computer;

    @Value("#{person.computerList.?[band eq '黑米'].![price][0]}")
    private int price;

    @Override
    public String toString() {
        return "SpEl{" +
                "num=" + num +
                ", pi=" + pi +
                ", personName='" + personName + '\'' +
                ", personSex='" + personSex + '\'' +
                ", random=" + random +
                ", list=" + list +
                ", map=" + map +
                ", computer=" + computer +
                ", price=" + price +
                ", personAge=" + personAge +
                '}';
    }

    @Value("#{person.age}")
    private int personAge;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }
}
