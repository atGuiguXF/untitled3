package com.heying.spring.xml;

import com.heying.spring.old.Vehicle;

public class Driver {


    private String name;

    private Integer age;

    private Vehicle vehicle;//从方法的参数 提升到属性

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Driver() {
    }

    public Driver(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public void drive(){
        System.out.println(this.age+"岁的老司机"+this.name+"正在开车");
        vehicle.run();
    }
}
