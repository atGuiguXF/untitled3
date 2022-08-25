package com.heying.spring.aop.xml.artist;

public class Performer {//核心业务


    public void perform(boolean success) {
        System.out.println("演员表演");
        if (!success)
            throw new IllegalStateException("表演失败 演员状态不佳");
    }
}
