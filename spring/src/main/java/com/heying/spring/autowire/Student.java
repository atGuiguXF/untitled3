package com.heying.spring.autowire;

public class Student {
    private String name;

    private int money;

    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    //借入
    public void borrow(int money){
        student.lend(money);
    }

    //借出
    public void lend(int money){
        this.money -= money;
        student.money += money;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}