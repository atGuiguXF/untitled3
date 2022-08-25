package com.heying.spring.aop.old;

public class Performer {//核心业务

    private Audience audience;//提升地位 搞成全局属性

    Performer(Audience audience) {
        this.audience = audience;
    }

    public void perform(boolean success) {
        audience.tackSeat();
        audience.turnOffPhone();
        System.out.println("演员表演");
        if (success)
            audience.applaud();
        else
            audience.throwEggs();

    }
}
