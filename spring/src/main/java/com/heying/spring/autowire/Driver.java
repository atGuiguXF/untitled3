package com.heying.spring.autowire;

import com.heying.spring.old.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Driver {

@Value("李师傅")
    private String name;

@Value("50")
    private Integer age;
//@Autowired//默认按照类型去找bean
//@Qualifier("tank")
//@Inject
//@Named("tank")
//    @Resource(name="car")//按照bean的名称注入
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

//    @Resource(name="car")//setter注入
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
@Autowired//构造器注入  优先考虑使用
    public Driver(@Qualifier("car") Vehicle vehicle) {
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
