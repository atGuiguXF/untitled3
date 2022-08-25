package com.heying.spring.javaconfig;

public class BBB {

private String name;

private int age;

private CCC ccc;

    @Override
    public String toString() {
        return "BBB{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ccc=" + ccc +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CCC getCcc() {
        return ccc;
    }

    public void setCcc(CCC ccc) {
        this.ccc = ccc;
    }
}
