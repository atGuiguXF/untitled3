package com.heying.ui;

import com.heying.entity.SysUser;
import com.heying.net.NetClient;
import com.heying.net.NetMsg;

import java.util.Scanner;

/**
 * 客户端的前端交互界面
 */
public class ClientUI {

    private Scanner in = new Scanner(System.in);


    public  ClientUI(){
        welcomeWindow();
    }

    public void welcomeWindow(){
        System.out.println("-----图书管理系统客户端----");
        loginWindow();
    }

    public void loginWindow(){
        System.out.println("----登录界面----");
        System.out.println("请输入用户名:");
        final String username = in.next();
        System.out.println("请输入密码:");
        final String password = in.next();
        final SysUser sysUser = new SysUser(null, username, password);
        //客户端->服务端 请求
        final NetMsg<SysUser> request = new NetMsg<>(sysUser, "USER_LOGIN");
        NetClient netClient = NetClient.getInstance();
        try {
            final NetMsg response = netClient.send(request);
            if(response.getType().equals("SUCCESS")){
                System.out.println(response.getData());
                mainWindow();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常");
        }

    }

    public void mainWindow(){
        System.out.println("----主菜单----");
        System.out.println("请选择:1.图书管理模块 2.客户管理模块 3.订单管理模块");
        int select = in.nextInt();
        switch (select){
            case 1://图书管理模块
                try {
                    new BookUI(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2://客户管理模块
                new CustomerUI(this);
                break;
            case 3://订单管理模块
                new OrdersUI(this);
                break;
        }
    }



    public static void main(String[] args) {
        new ClientUI();
    }
}
