package com.heying.dao;

import com.heying.entity.Customer;
import com.heying.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    JDBCUtil jdbcUtil = new JDBCUtil();

    public List<Customer> query(Customer condition) throws Exception {//????
        String select = "select * from tbl_customer where 1=1";
        List<Object> list = new ArrayList<>();
        System.out.println("========");
        System.out.println(condition);
        if (condition.getCustomer() != null) {
            select += " and customer = ? ";
            list.add(condition.getCustomer());
        }
        if (condition.getCustomer_name() != null) {
            select += " and customer_name like ?";
            list.add("%" + condition.getCustomer_name() + "%");
        }
        if (condition.getCity() != null) {
            select += " and city like ? ";
            list.add("%" + condition.getCity() + "%");
        }
        System.out.println(select);
        System.out.println(list);
        System.out.println("========");
        System.out.println(condition);
        return jdbcUtil.queryMany(select, Customer.class, list.toArray());
    }

    public void insert(Customer customer) throws Exception {
        jdbcUtil.update("insert into tbl_customer values(?,?,?,?,?,?,?)",
                customer.getCustomer(), customer.getCustomer_name(),
                customer.getAddress(), customer.getCity(), customer.getState(),
                customer.getZip(), customer.getReferred());
    }

    public void update(Customer customer) throws Exception {
        if (customer.getCustomer_name() != null) {
            jdbcUtil.update("update tbl_customer set customer_name =? where customer = ? ",
                    customer.getCustomer_name(), customer.getCustomer());
            if (customer.getState() != null) {
                jdbcUtil.update("update tbl_customer set state = ? where customer = ?",
                        customer.getState(), customer.getCustomer());
            }
        }
    }

    //调用删除
    public void delete(Customer customer) throws Exception {
        if (customer.getCustomer()!=null)
        jdbcUtil.update("delete from tbl_customer where customer = ?", customer.getCustomer());
    }

}
