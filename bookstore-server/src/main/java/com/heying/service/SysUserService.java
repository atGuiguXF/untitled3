package com.heying.service;

import com.heying.dao.SysUserDao;
import com.heying.entity.SysUser;
import com.heying.net.NetMsg;

//业务逻辑层 数据的加工
public class SysUserService {

    private SysUserDao sysUserDao = new SysUserDao();

    public NetMsg<String> checkLogin(NetMsg<SysUser> request) throws Exception {
        final SysUser sysUser1 = sysUserDao.selectByUsername(request.getData().getUsername());
        if (null == sysUser1)
            return new NetMsg<>("用户名不存在", "ERROR");
        final SysUser sysUser2 = sysUserDao.selectByUsernameAndPassword(request.getData());
        if(null == sysUser2)
            return new NetMsg<>("密码不正确", "ERROR");
        return new NetMsg<>("登录成功", "SUCCESS");
    }
}
