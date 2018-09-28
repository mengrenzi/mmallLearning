package com.mmall.common;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: Created in 16:52 2018/9/24
 * @Copyright： 2018, Renzi Meng, All Rights Reserved.
 */

public class Const {

    public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0; // 用户
        int ROLE_ADMIN = 1; // 管理员
    }

}
