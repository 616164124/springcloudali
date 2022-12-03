package com.com.response;

/**
 * 接口返回枚举定义
 * 该类自增不减
 * 错误的code定义规范：应用名简称或者应用代号+“-”+6位数字码
 */
public enum RestCodeEnum {
    /***成功********/
    SUCCESS("000000", "成功"),
    /**********************************************************************************/
    ERROR("99998","未知错误。。。。。"),
    /*****参数错误：10001-19999***********************************************************/
    PARAM_IS_INVALID("10001", "参数无效"),
    /***********用户错误：20001-29999****************************************************/
    USER_NOT_LOGGED_IN("20001", "用户未登录，请登录"),
    USER_LOGIN_ERROR("20002", "账号不存在或者密码错误"),
    USER_ACCOUNT_FORBIDDEN("20003", "账号已被禁用"),
    USER_NOT_EXIST("20004", "用户不存在"),
    USER_HAS_EXISTED("20005", "用户已存在"),
    /*************第三方接口请求：30001-39999******************************************************/
    THIRD_TOKEN_GET_FAILED("30001", "token获取失败"),
    THIRD_TOKEN_INVALID("30002", "token失效"),
    /**********************:40001-49999*************************************************/

    /**********************:50001-59999*************************************************/

    /**********************99999*************************************************/
    ERROR_CONTACT_CUSTOMER_SERVICE("99999","系统维护中。。。。。"),
    RC91000("91000","91000错误"),

    ;



    private String code;
    private String msg;

    RestCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.putMsg(RestCodeEnum.SUCCESS.msg);
        System.out.println(RestCodeEnum.SUCCESS.code);
    }
}
