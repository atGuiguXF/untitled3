package com.heying.ssm.service;

import com.heying.ssm.entity.UserInfo;
import com.heying.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceIn {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo queryOne(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override//重写UserServiceIn接口方法
    public Integer addOne(UserInfo userInfo) {
        return userMapper.addOne(userInfo);
    }


    @Override
    public Boolean deleteOne(String username){
        return userMapper.deleteOne(username);
    }

    @Override
    public Boolean updateOne(UserInfo userInfo) {
        return userMapper.updatePassword(userInfo);
    }
}
