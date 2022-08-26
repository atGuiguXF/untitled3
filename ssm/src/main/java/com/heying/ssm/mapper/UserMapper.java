package com.heying.ssm.mapper;

import com.heying.ssm.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository  //组件
@Mapper
public interface UserMapper {
    @Select("select * from userinfo where username=#{username}")
    UserInfo selectByUsername(String username);

    @Insert("insert into userinfo values(#{username},#{password})")
    Integer addOne(UserInfo userInfo);

    @Delete("delete from userinfo where username = #{username}")
    Boolean deleteOne(String username);

    @Update("update userinfo set password = #{password} where username =#{username}")
    Boolean updatePassword(UserInfo userInfo);
}