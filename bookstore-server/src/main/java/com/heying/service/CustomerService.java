package com.heying.service;

import com.heying.dao.CustomerDao;
import com.heying.entity.Customer;
import com.heying.net.NetMsg;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public NetMsg<List<Customer>> query(NetMsg<Customer> request) throws Exception {
        final List<Customer> list = customerDao.query(request.getData());
        return new NetMsg<>(list, "SUCCESS");
    }

    public NetMsg<String> add(NetMsg<Customer> request) throws Exception {
        customerDao.insert(request.getData());
        return new NetMsg<>("添加成功", "SUCCESS");
    }

    public NetMsg<String> update(NetMsg<Customer> request) throws Exception {
        customerDao.update(request.getData());
        return new NetMsg<>("修改成功", "SUCCESS");
    }

    public NetMsg<String> delete(NetMsg<Customer> request) throws Exception {
        customerDao.delete(request.getData());
        return new NetMsg<>("删除成功", "SUCCESS");
    }

}
