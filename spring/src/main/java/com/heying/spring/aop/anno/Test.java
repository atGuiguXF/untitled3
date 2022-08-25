package com.heying.spring.aop.anno;

import com.heying.spring.SpringConfig;
import com.heying.spring.aop.anno.artist.Performer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        final Performer performer = context.getBean(Performer.class);
//        performer.perform(true);

        Encoreable encoreable = (Encoreable) performer ;
        encoreable.performEncore();
    }
}
