package com.heying.net;

import com.heying.service.BookService;
import com.heying.service.CustomerService;
import com.heying.service.OrdersService;
import com.heying.service.SysUserService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer {

    public NetServer() {

    }

    public void start() throws Exception {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务端已启动，开始工作");
        final Socket socket = server.accept();
        final ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        final ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        while (true) {
            final NetMsg request = (NetMsg) ois.readObject();
            System.out.println("request=" + request);
            String type = request.getType();
            //用户模块
            if (type.startsWith("USER")) {
                final SysUserService sysUserService = new SysUserService();
                //登录功能
                if (type.endsWith("LOGIN")) {
                    final NetMsg response = sysUserService.checkLogin(request);
                    oos.writeObject(response);
                }
            }
            //图书模块
            else if (type.startsWith("BOOK")) {
                final BookService bookService = new BookService();
                //查询功能
                if (type.endsWith("QUERY")) {
                    final NetMsg response = bookService.query(request);
                    oos.writeObject(response);
                } else if (type.endsWith("ADD")) {
                    final NetMsg response = bookService.add(request);
                    oos.writeObject(response);
                } else if (type.endsWith("ALTER")) {
                    final NetMsg response = bookService.update(request);
                    oos.writeObject(response);
                } else if (type.endsWith("DELETE")) {
                    final NetMsg response = bookService.delete(request);
                    oos.writeObject(response);
                }
            }

            //顾客模块
            else if (type.startsWith("CUSTOMER")) {
                final CustomerService customerService = new CustomerService();
                if (type.endsWith("QUERY")) {
                    final NetMsg response = customerService.query(request);
                    oos.writeObject(response);
                } else if (type.endsWith("ADD")) {
                    final NetMsg response = customerService.add(request);
                    oos.writeObject(response);
                } else if (type.endsWith("ALTER")) {
                    final NetMsg response = customerService.update(request);
                    oos.writeObject(response);
                } else if (type.endsWith("DELETE")) {
                    final NetMsg response = customerService.delete(request);
                    oos.writeObject(response);
                }
            }
            //订单模块
            else if (type.startsWith("ORDERS")) {
                final OrdersService ordersService = new OrdersService();
                if (type.endsWith("QUERY")) {
                    final NetMsg response = ordersService.query(request);
                    System.out.println(request);
                    oos.writeObject(response);
                } else if (type.endsWith("ADD")) {
                    final NetMsg response = ordersService.add(request);
                    oos.writeObject(response);
                } else if (type.endsWith("ALTER")) {
                    final NetMsg response = ordersService.update(request);
                    oos.writeObject(response);
                } else if (type.endsWith("DELETE")) {
                    final NetMsg response = ordersService.delete(request);
                    oos.writeObject(response);
                }

            }
        }
    }
}
