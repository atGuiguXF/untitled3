package com.heying.spring.spel;

import com.heying.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
//        final DbConfig dbConfig = context.getBean("dbConfig", DbConfig.class);
//        System.out.println(dbConfig);

//        final Person person = context.getBean(Person.class);
//        System.out.println(person);

        final SqEl spEl = context.getBean(SqEl.class);
        System.out.println(spEl);
    }
}
