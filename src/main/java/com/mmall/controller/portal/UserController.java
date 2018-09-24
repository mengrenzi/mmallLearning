package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: Created in 19:30 2018/9/21
 * @Copyright： 2018, Renzi Meng, All Rights Reserved.
 */

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
      *@Description: 用户登陆
      *service --> mybatis.dao
      *@Param:  [username, password, session]
      *@Return: java.lang.Object
      */
    @RequestMapping(value="login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login ( username, password );
        if(response.isSuccess()){
            session.setAttribute ( Const.CURRENT_USER, response.getData ());
        }
        return response;
    }
}
