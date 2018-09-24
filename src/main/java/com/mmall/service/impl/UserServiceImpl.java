package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: Created in 20:02 2018/9/21
 * @Copyright： 2018, Renzi Meng, All Rights Reserved.
 */

@Service("iUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    // 通过 @Autowired 的使用实现自动装配功能
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername ( username );
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage ( "用户名不存在" );
        }

        // todo 密码登录MD5


        User user = userMapper.selectLogin ( username, password );

        if(user == null){
            return ServerResponse.createByErrorMessage ( "密码错误" );
        }

        user.setPassword ( org.apache.commons.lang3.StringUtils.EMPTY );
        return ServerResponse.createBySuccess ("登录成功", user);

    }
}
