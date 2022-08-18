package com.heying;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Student {
    private Integer id;

    private String name;

    private Integer height;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date birthday;
    private Double weight;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", birthday=" + birthday +
                ", weight=" + weight +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Student() {
    }

    public Student(Integer id, String name, Integer height, Date birthday, Double weight) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.birthday = birthday;
        this.weight = weight;
    }
}
