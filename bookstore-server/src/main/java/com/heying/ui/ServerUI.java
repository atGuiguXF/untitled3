package com.heying.ui;

import com.heying.net.NetServer;

public class ServerUI {



    public ServerUI(){
        System.out.println("----图书管理系统服务端----");
        try {
            new NetServer().start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常");
        }
    }

    public static void main(String[] args) {
        new ServerUI();
    }
}
