package com.heying.service;

import com.heying.dao.OrdersDao;
import com.heying.entity.Orders;
import com.heying.net.NetMsg;

import java.util.List;

public class OrdersService {
    private OrdersDao ordersDao = new OrdersDao();

    public NetMsg<List<Orders>> query(NetMsg<Orders> request) throws Exception {
        final List<Orders> list = ordersDao.query(request.getData());
        return new NetMsg<>(list, "SUCCESS");
    }

    public NetMsg<String> add(NetMsg<Orders> request) throws Exception {
        ordersDao.insert(request.getData());
        return new NetMsg<>("添加成功", "SUCCESS");
    }
    public NetMsg<String>update(NetMsg<Orders>request) throws Exception {
        ordersDao.update(request.getData());
        return new NetMsg<>("修改成功 :)","SUCCESS");
    }
    public NetMsg<String>delete(NetMsg<Orders>request) throws Exception {
        ordersDao.delete(request.getData());
        return new NetMsg<>("删除成功 -> :(","SUCCESS");
    }
}
