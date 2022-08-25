package com.heying.spring.aop.anno;

public class DefaultEncoreable implements Encoreable {

    @Override
    public void performEncore() {
        System.out.println("再表演一个节目");
    }
}
