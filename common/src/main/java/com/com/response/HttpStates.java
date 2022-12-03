package com.com.response;

//简易版本
public interface HttpStates {
//
//200	OK:请求
//400	Bad Request：客户端请求的语法错误，服务器无法理解
//500	Internal Server Error：内部服务器错误
    //json 中的code值
//200	结果正常
//300	参数错误
//520	后端服务请求失败
//530	服务繁忙

    public static final int Success = 200;
    public static final int Bad_Request = 400;
    public static final int Server_Error = 500;
    public static final int Parameter_Error = 300;
    public static final int Request_Failed = 520;
    public static final int Busy_Service = 530;
    public static final int Server_Error_Msg = 501;
}
