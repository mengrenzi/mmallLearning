package com.mmall.common;

import net.sf.jsqlparser.schema.Server;

/**
 * @Description:
 * @Author: Renzi Meng
 * @Date: Created in 20:25 2018/9/21
 * @Copyright： 2018, Renzi Meng, All Rights Reserved.
 */

public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
