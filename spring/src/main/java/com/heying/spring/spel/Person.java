package com.heying.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Person {

    @Value("${person.name}")
    private String name;
    @Value("${person.sex}")
    private String sex;
    @Value("${person.age}")
    private int age;

    public List<Computer> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    private List<Computer> computerList
            = List.of(new Computer("小米",2000),
            new Computer("大米",1000),
            new Computer("黑米",5000),
            new Computer("红米",4000),
            new Computer("中米",3000));

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
