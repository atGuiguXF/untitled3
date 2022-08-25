package com.heying.spring.aop.xml;

import com.heying.spring.aop.xml.artist.Performer;
import com.heying.spring.aop.xml.artist.Singer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final Performer performer = context.getBean(Performer.class);
        final Singer singer = context.getBean(Singer.class);
//        performer.perform(true);
//        singer.sing(true);
        Encoreable encoreable = (Encoreable) performer;
        encoreable.performEncore();

    }
}
