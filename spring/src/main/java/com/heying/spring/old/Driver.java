package com.heying.spring.old;

public class Driver {


    private String name;

    private Integer age;

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
    public void drive(Vehicle vehicle){
        System.out.println(this.age+"岁的老司机"+this.name+"正在开车");
        vehicle.run();
    }
}
