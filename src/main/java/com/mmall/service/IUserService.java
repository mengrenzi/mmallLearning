package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: Created in 20:01 2018/9/21
 * @Copyright： 2018, Renzi Meng, All Rights Reserved.
 */

public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);
}
