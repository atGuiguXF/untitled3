package com.heying.ssm.service;

import com.heying.ssm.entity.UserInfo;

public interface UserServiceIn {
    UserInfo queryOne(String username);

    Integer addOne(UserInfo userinfo);

    Boolean deleteOne(String username);

    Boolean updateOne(UserInfo userInfo);
}
