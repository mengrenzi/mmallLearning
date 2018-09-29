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

    /**
      *@Description: 
      *@Param:  [session]
      *@Return: com.mmall.common.ServerResponse<java.lang.String>
      */
    @RequestMapping(value="logout.do", method=RequestMethod.GET)
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess ();
    }

    @RequestMapping(value = "register.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> register(User user) {
        return iUserService.register ( user );
    }

    @RequestMapping(value = "check_valid.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type){
        return iUserService.checkValid ( str, type );
    }

    @RequestMapping(value = "get_user_info.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            return ServerResponse.createBySuccess (user);
        }
        return ServerResponse.createByErrorMessage ( "用户未登录，无法获取当前用户的信息" );
    }

    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username){
        return iUserService.selectQuestion("username");
    }

    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forGetQuestion(String username){
        return iUserService.selectQuestion ( username );
    }


    @RequestMapping(value = "forget_check_answer.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer){
        return iUserService.checkAnswer ( username, question, answer ) ;
    }
}
