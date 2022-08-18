package com.heying.ui;

import com.heying.entity.Customer;
import com.heying.net.NetClient;
import com.heying.net.NetMsg;

import java.util.List;
import java.util.Scanner;

public class CustomerUI {

    private ClientUI clientUI;

    private Scanner in = new Scanner(System.in);

    public CustomerUI(ClientUI clientUI) {
        this.clientUI = clientUI;
        mainWindow();
    }

    public void mainWindow() {
        System.out.println("请选择功能：1.查询客户信息 2.添加客户" +
                " 3.修改客户信息 4.删除客户  0.返回上一级菜单");
        int select = in.nextInt();
        switch (select) {
            case 1:
                queryWindow();
                break;
            case 2:
                try {
                    addWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    public void deleteWindow() {//删除方法
        System.out.println("请输入要删除顾客的ID：");
        Integer customer = in.nextInt();
        final NetClient netClient = NetClient.getInstance();
        final Customer customer1 = new Customer();

        customer1.setCustomer(customer);
        try {
            final NetMsg response = netClient.send(new NetMsg(customer1, "CUSTOMER_DELETE"));
            System.out.println(response);
            if (response.getType().equals("SUCCESS")) {
                System.out.println(response.getData());
                mainWindow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//删除方法

    public void updateWindow() {//修改方法
        System.out.println("请输入要修改顾客的ID：");
        Integer customer = in.nextInt();
        final NetClient netclient = NetClient.getInstance();
        final Customer customer1 = new Customer();
        customer1.setCustomer(customer);

        try {
            final NetMsg response = netclient.send(new NetMsg(customer1, "CUSTOMER_QUERY"));
            System.out.println(response.getData());
            if (response.getType().equals("SUCCESS")) {
                System.out.println("请选择修改的内容： 1.姓名 2.省会");
                Integer select = in.nextInt();
                switch (select) {
                    case 1:
                        System.out.println("请输入修改后的姓名:");
                        String customerName = in.next();
                        final Customer customer2 = new Customer();
                        customer2.setCustomer(customer);
                        customer2.setCustomer_name(customerName);
                        final NetMsg customer_alter = netclient.send(new NetMsg(customer2, "CUSTOMER_ALTER"));
                        if (customer_alter.getType().equals("SUCCESS")) {
                            System.out.println((customer_alter.getData()));
                            mainWindow();
                        }
                        break;
                    case 2:
                        System.out.println("请输入修改后的省会：");
                        String state = in.next();
                        final Customer customer3 = new Customer();
                        customer3.setCustomer(customer);
                        customer3.setState(state);
                        final NetMsg customer_alter1 = netclient.send(new NetMsg(customer3, "CUSTOMER_ALTER"));
                        if (customer_alter1.getType().equals("SUCCESS")) {
                            System.out.println(customer_alter1.getData());
                            mainWindow();
                        }
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addWindow() throws Exception {//添加方法
        System.out.println("请输入顾客ID：");
        Integer customer = in.nextInt();
        System.out.println("请输入顾客姓名：");
        String customer_name = in.next();
        System.out.println("请输入顾客地址：");
        String address = in.next();
        System.out.println("请输入顾客所在城市：");
        String city = in.next();
        System.out.println("请输入顾客所在省市：");
        String state = in.next();
        System.out.println("请输入邮编");
        String zip = in.next();
        System.out.println("请输入推荐会员号");
        Integer referred = in.nextInt();

        final Customer customer1 = new Customer(customer, customer_name,
                address, city, state, zip, referred);
        final NetClient netClient = NetClient.getInstance();
        final NetMsg response = netClient.send(new NetMsg(customer1, "CUSTOMER_ADD"));
        if (response.getType().equals("SUCCESS")) {
            System.out.println(response.getData());
            mainWindow();
        }
    }

    public void queryWindow() {//查询方法
        System.out.println("请选择查询条件：1.顾客ID 2.顾客姓名 3.顾客城市 0.所有顾客");
        int select = in.nextInt();
        final NetClient netClient = NetClient.getInstance();
        final Customer customer = new Customer();
        switch (select) {
            case 1:
                System.out.println("请输入顾客ID：");
                int customer1 = in.nextInt();
                customer.setCustomer(customer1);
                break;
            case 2:
                System.out.println("请输入顾客姓名：");
                String customerName = in.next();
                customer.setCustomer_name(customerName);
                break;
            case 3:
                System.out.println("请输入顾客城市：");
                String city = in.next();
                customer.setCity(city);
                break;
            case 0:
                customer.toString();
                break;
        }
        try {
            final NetMsg<List<Customer>> response = netClient.send(new NetMsg(customer, "CUSTOMER_QUERY"));
            if (response.getType().equals("SUCCESS")) {
//                System.out.println(response);
                printCustomer(response.getData());
            }
            mainWindow();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常");
            queryWindow();
        }

    }

    public void printCustomer(List<Customer> list) {//打印方法
        System.out.println("顾客ID\t\t姓名\t\t地址\t\t城市\t\t省市\t\t邮编\t\t推荐会员");
        list.forEach(c -> System.out.println(c.getCustomer() + "\t\t" +
                c.getCustomer_name() + "\t\t" + c.getAddress() + "\t\t" +
                c.getCity() + "\t\t" + c.getState() + "\t\t" +
                c.getZip() + "\t\t" + c.getReferred()));
    }
}
