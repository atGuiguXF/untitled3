package com.heying.spring.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component//组件
@Aspect//加切面
public class Audience {//观众

    @Pointcut("execution(* com.heying.spring.aop.anno.artist.*.*(..))")
    public void perform() {
    }

    @Around("perform()")
    public void arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("观众入场");
        joinPoint.proceed();
        System.out.println("观众看呆了");
    }

    @Before("perform()")
    public void tackSeat() {
        System.out.println("观众找座位");
    }

    @Before("perform()")
    public void turnOffPhone() {
        System.out.println("观众关手机");
    }

    @AfterReturning("perform()")
    public void applaud() {
        System.out.println("观众疯狂鼓掌");
    }

    @AfterThrowing("perform()")
    public void throwEggs() {
        System.out.println("观众扔鸡蛋砸大黄蜂");
    }

    @After("perform()")
    public void goOut() {
        System.out.println("观众退场");
    }
}
