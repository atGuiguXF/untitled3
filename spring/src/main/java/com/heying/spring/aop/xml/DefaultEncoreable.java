package com.heying.spring.aop.xml;

public class DefaultEncoreable implements Encoreable{

    @Override
    public void performEncore() {
        System.out.println("再表演一个节目");
    }
}
