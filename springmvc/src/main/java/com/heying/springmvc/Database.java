package com.heying.springmvc;

import com.heying.springmvc.entity.User;

import java.util.HashMap;
import java.util.Map;

public class Database {

    public static Map<Integer, User> userMap = new HashMap<>();

    static{
        userMap.put(5, new User(5, "qqq", "111", "男", 21, new String[]{"唱歌","跳舞"}));
        userMap.put(6, new User(6, "www", "222", "女", 21, new String[]{"唱歌","跳舞"}));
        userMap.put(7, new User(7, "eee", "333", "男", 21, new String[]{"唱歌","跳舞"}));
    }
}
