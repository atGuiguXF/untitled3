package com.heying.spring.aop.anno.artist;

import org.springframework.stereotype.Component;

@Component
public class Singer {

    public void sing(boolean success) {
        System.out.println("歌手唱歌");
        if (!success)
            throw new IllegalStateException("演唱会失败 歌手假唱被发现");
    }
}
