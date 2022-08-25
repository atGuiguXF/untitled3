package com.heying.spring.aop.old;

public class Singer {
    private Audience audience;

    public Singer(Audience audience) {
        this.audience = audience;
    }

    public void sing(boolean success) {
        audience.tackSeat();
        audience.turnOffPhone();
        System.out.println("歌手唱歌");
        if (success)
            audience.applaud();
        else
            audience.throwEggs();
    }
}
