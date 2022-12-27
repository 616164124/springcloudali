package com.mk.common;

/**
 *
 *
 * encoded: UTF-8
 *
 * 接口返回枚举定义
 * 只增加不删除不修改
 * <p>
 * //200	OK:请求
 * //400	Bad Request：客户端请求的语法错误，服务器无法理解
 * //500	Internal Server Error：内部服务器错误
 * //json 中的code值
 * //200	结果正常
 * //300	参数错误
 * //520	后端服务请求失败
 * //530	服务繁忙
 */
public enum CodeEnum {
    /**
     * 成功
     */
    SUCCESS("000000", "成功", false),
    /**
     * 错误
     */
    ERROR("999999", "错误", false),
    ERROR_MSG("999999", "MSG1", false),

    /**
     * 异常
     */
    Exception("9999999", "异常", false),
    /*****参数错误：10001-19999***********************************************************/
    PARAM_IS_INVALID("10001", "参数无效", false),
    /***********用户错误：20001-29999****************************************************/
    USER_NOT_LOGGED_IN("20001", "用户未登录，请登录", false),
    USER_LOGIN_ERROR("20002", "账号不存在或者密码错误", false),
    USER_ACCOUNT_FORBIDDEN("20003", "账号已被禁用", false),
    USER_NOT_EXIST("20004", "用户不存在", false),
    USER_HAS_EXISTED("20005", "用户已存在", false),
    /*************第三方接口请求：30001-39999******************************************************/
    THIRD_TOKEN_GET_FAILED("30001", "token获取失败", false),
    THIRD_TOKEN_INVALID("30002", "token失效", false),
    /**********************:40001-49999*************************************************/

    /**********************:50001-59999*************************************************/

    /**********************99999*************************************************/
    ERROR_CONTACT_CUSTOMER_SERVICE("99999", "系统维护中。。。。。", false),
    RC91000("91000", "91000错误", false),

    ;


    private String code;
    private String msg;
    private boolean flag;

    CodeEnum(String code, String msg, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
