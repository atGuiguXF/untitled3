package com.heying.spring.transaction;

import com.heying.spring.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserInfo user1 = new UserInfo("www", "111");
        UserInfo user2 = new UserInfo("www", "222");
        final UserService userService = context.getBean(UserService.class);
//        userService.addTwoUsers(user1, user2);

        new Thread(()->{
            try {
                userService.addTwoUsers(user1,user2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                userService.addTwoUsers(user1,user2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
