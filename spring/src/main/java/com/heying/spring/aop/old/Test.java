package com.heying.spring.aop.old;

public class Test {
    public static void main(String[] args) {
        final Audience audience = new Audience();
        final Performer performer = new Performer(audience);
        performer.perform(true);
    }
}

