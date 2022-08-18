package com.heying.dao;

import com.heying.entity.SysUser;
import com.heying.util.JDBCUtil;

/**
 * 数据访问对象
 */
public class SysUserDao {
    JDBCUtil jdbcUtil = new JDBCUtil();

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     * @throws Exception
     */
    public SysUser selectByUsername(String username) throws Exception {
        return jdbcUtil.queryOne("select * from tbl_sysuser where username=?", SysUser.class, username);
    }

    /**
     * 根据用户名和密码查询用户
     * @param sysUser
     * @return
     * @throws Exception
     */
    public SysUser selectByUsernameAndPassword(SysUser sysUser) throws Exception {
        return jdbcUtil.queryOne("select * from tbl_sysuser where username=? and password=?",
                SysUser.class, sysUser.getUsername(),sysUser.getPassword());
    }
}
