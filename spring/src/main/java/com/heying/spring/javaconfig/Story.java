package com.heying.spring.javaconfig;

import com.heying.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Story {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        final BBB bbb = context.getBean("bbb", BBB.class);
        System.out.println(bbb);
    }
}
