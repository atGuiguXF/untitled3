package com.heying.ui;

import com.heying.entity.Orders;
import com.heying.net.NetClient;
import com.heying.net.NetMsg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrdersUI {
    private ClientUI clientUI;
    private Scanner in = new Scanner(System.in);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public OrdersUI(ClientUI clientUI) {
        this.clientUI = clientUI;
        mainWindow();
    }

    public void mainWindow() {
        System.out.println("=====请选择功能：======");
        System.out.println("1.查询订单 2.添加订单 3.修改订单 4.删除订单 0.返回上一级菜单");
        Integer select = in.nextInt();
        switch (select) {
            case 1:
                try {
                    queryWindow();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                addWindow();
                break;

            case 3:
                updateWindow();
                break;

            case 4:
                deleteWindow();
                break;

            case 0:
                clientUI.mainWindow();
                break;

        }
    }

    public void queryWindow() throws ParseException {
        System.out.println("=========查看订单========");
        System.out.println("请选择查询条件 1.订单号 2.订单省会 3.查询所有订单 0.返回上一级菜单");
        Integer select = in.nextInt();
        final NetClient netClient = NetClient.getInstance();
        final Orders orders = new Orders();
        switch (select) {
            case 1:
                System.out.println("请输入要查询的订单号");
                Integer orderNo = in.nextInt();
                orders.setOrderno(orderNo);
                break;
            case 2:
                System.out.println("请输入查询的省会");
                String shipstate = in.next();
//                final Date date = simpleDateFormat.parse(orderDate);
                orders.setShipstate(shipstate);
                break;

            case 3:
                orders.toString();
                break;
            case 0:
                return;
        }
        try {
            final NetMsg<List<Orders>> response = netClient.send(new NetMsg(orders, "ORDERS_QUERY"));
            if (response.getType().equals("SUCCESS")) {
                printOrders(response.getData());
            }
            mainWindow();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常");
            queryWindow();
        }

    }

    public void addWindow() {

        final Date date = new Date();
        System.out.println("===添加图书 Method===");
        System.out.println("请输入要添加的订单号：");
        Integer orderno = in.nextInt();
        System.out.println("请输入要添加的顾客编号：");
        Integer customer = in.nextInt();
//        System.out.println("请输入要添加的订单日期：");
//        String orderDate = in.next();
//        final SimpleDateFormat format = new SimpleDateFormat();
//        try {
//            final Date parse = format.parse(orderDate);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println("请输入要添加的发货日期：");
//        String shipDate = in.next();
//        try {
//            final Date parse1 = format.parse(shipDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        System.out.println("请输入添加的发货地点：");
        String shipStreet = in.next();
        System.out.println("请输入添加的发货城市");
        String shipCity = in.next();
        System.out.println("请输入添加的省市：");
        String shipState = in.next();
        System.out.println("请输入添加的邮编：");
        String shipZip = in.next();
        final Orders orders = new Orders(orderno, customer, date, date, shipStreet,
                shipCity, shipState, shipZip);
        final NetClient netClient = NetClient.getInstance();
        try {
            final NetMsg response = netClient.send(new NetMsg(orders, "ORDERS_ADD"));
            if (response.getType().equals("SUCCESS")) {
                System.out.println(response.getData());
                mainWindow();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常");
            mainWindow();
        }

    }

    public void updateWindow() {
        System.out.println("==修改界面==");
        System.out.println("请输入要修改的订单号码：");
        Integer orderno = in.nextInt();
        final NetClient netClient = NetClient.getInstance();
        final Orders orders = new Orders();
        orders.setOrderno(orderno);
        try {
            final NetMsg response = netClient.send(new NetMsg(orders, "ORDERS_QUERY"));
            System.out.println(response.getData());
            if (response.getType().equals("SUCCESS")) {
                System.out.println("请选择修改内容 1.修改发货地点  2.修改发货城市");
                Integer select = in.nextInt();
                switch (select) {
                    case 1:
                        System.out.println("请输入修改后的发货地点：");
                        String shipStreet = in.next();
                        final Orders orders1 = new Orders();
                        orders1.setOrderno(orderno);
                        orders1.setShipstreet(shipStreet);
                        final NetMsg orders_alter = netClient.send(new NetMsg(orders1, "ORDERS_ALTER"));
                        if (orders_alter.getType().equals("SUCCESS")){
                            System.out.println(orders_alter.getData());
                            mainWindow();
                        }
                        break;
                    case 2:
                        System.out.println("请输入修改后的发货城市：");
                        String shipcity = in.next();
                        final Orders orders2 = new Orders();
                        orders2.setOrderno(orderno);
                        orders2.setShipcity(shipcity);
                        final NetMsg orders_alter1 = netClient.send(new NetMsg(orders2, "ORDERS_ALTER"));
                        if (orders_alter1.getType().equals("SUCCESS")){
                            System.out.println(orders_alter1.getData());
                            mainWindow();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteWindow() {
        System.out.println("==删除Method==");
        System.out.println("请输入要删除的订单号码：");
        Integer orderno = in.nextInt();
        final NetClient netClient = NetClient.getInstance();
        final Orders orders = new Orders();
        orders.setOrderno(orderno);
        try {
            final NetMsg response = netClient.send(new NetMsg(orders, "ORDERS_DELETE"));
            if (response.getType().equals("SUCCESS")){
                System.out.println(response.getData());
                mainWindow();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printOrders(List<Orders> list) {
        System.out.println("订单号\t\t顾客编号\t\t订单日期\t\t发货日期\t\t发货地点\t\t" +
                "发货城市\t\t发货省\t\t邮编");
        list.forEach(o -> System.out.println(o.getOrderno() + "\t\t" + o.getCustomer() + "\t\t" +
                o.getOrderdate() + "\t\t" + o.getShipdate() + "\t\t" + o.getShipstreet() + "\t\t"
                + o.getShipcity() + "\t\t" + o.getShipstate() + "\t\t" + o.getShipzip()));
    }
}
