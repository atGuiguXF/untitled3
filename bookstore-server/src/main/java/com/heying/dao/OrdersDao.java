package com.heying.dao;

import com.heying.entity.Orders;
import com.heying.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
    JDBCUtil jdbcUtil = new JDBCUtil();

    public List<Orders> query(Orders condition) throws Exception {
        String select = "select * " +
                " from tbl_orders o join tbl_customer c on o.customer = c.customer where 1 = 1 ";

        List<Object> list = new ArrayList<>();
        if (condition.getOrderno() != null) {
            select += "and orderno = ?";
            list.add(condition.getOrderno());
        }
        if (condition.getShipstate() != null) {
            select += "and o.shipstate = ?";
            list.add(condition.getShipstate());
        }
        System.out.println(select);
        System.out.println(list);
        return jdbcUtil.queryMany(select, Orders.class, list.toArray());
    }

    public void insert(Orders orders) throws Exception {
        jdbcUtil.update("insert into tbl_orders values(?,?,?,?,?,?,?,?)",
                orders.getOrderno(), orders.getCustomer(),
                orders.getOrderdate(), orders.getShipdate(),
                orders.getShipstreet(), orders.getShipcity(),
                orders.getShipstate(), orders.getShipzip());
    }
    public void update(Orders orders) throws Exception {
        if (orders.getShipstreet()!=null) {
            jdbcUtil.update("update tbl_orders set shipstreet=? " +
                    "where orderno = ?", orders.getShipstreet(), orders
                    .getOrderno());
        }
        if (orders.getShipcity()!=null){
            jdbcUtil.update("update tbl_orders set shipcity = ? where orderno = ?",
                    orders.getShipcity(),orders.getOrderno());
        }
    }
    public void delete(Orders orders) throws Exception {
        jdbcUtil.update("delete from tbl_orders  where orderno = ?",orders.getOrderno());
    }
}
