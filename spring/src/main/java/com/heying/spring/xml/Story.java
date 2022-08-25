package com.heying.spring.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IoC 控制反转
 * 对象的控制权由 程序员 反转为容器
 * DI 依赖注入
 * 对象的依赖关系是由容器帮我们注入的 装配对象以及对象之间的依赖关系
 * <p>
 * 一切都是为了解耦  低耦合度  方便扩展
 */
public class Story {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        final Driver driver = context.getBean("driver", Driver.class);
//        final Driver driver1 = context.getBean("driver", Driver.class);
//        System.out.println(driver == driver1);
////        driver.drive();
//
//        final AAA aaa = context.getBean("aaa", AAA.class);
//        System.out.println(aaa);

        final Student borrower = context.getBean("borrower", Student.class);
        final Student lender = context.getBean("lender", Student.class);
        System.out.println(borrower);
        System.out.println(lender);
        borrower.borrow(100);
        System.out.println("=======借钱后===========");
        System.out.println(borrower);
        System.out.println(lender);
    }
}
