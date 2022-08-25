package com.heying.spring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {//观众

    public void takeSeat() {
        System.out.println("观众找座位");
    }

    public void turnOffPhone() {
        System.out.println("观众关手机");
    }

    public void applaud() {
        System.out.println("观众疯狂鼓掌");
    }

    public void throwEggs() {
        System.out.println("观众扔鸡蛋砸大黄蜂");
    }

    public void goOut() {
        System.out.println("观众退场");
    }

    public void arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("观众入场");
        joinPoint.proceed();//等价于分界线
        System.out.println("观众惊呆了");
    }
}
