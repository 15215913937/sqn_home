package com.sqn.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqn.library.common.Result;
import com.sqn.library.controller.dto.UserPasswordDTO;
import com.sqn.library.controller.dto.UserResetPwdDTO;
import com.sqn.library.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    //查询用户名
    @Select("select password from user where username = #{username}")
    User selectByName(String username);

    // 一对多查询
    Page<User> findPage(Page<User> page, @Param("name") String name, @Param("role") String role);

    @Update("update user set password = #{newPassword} where username = #{username}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

    @Update("update user set password = #{newPassword} where username = #{username}")
    int resetPwd(UserResetPwdDTO userResetPwdDTO);
}
