package com.com.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * resultCode,resultMsg  必须从ResetCodeEnum中获取
 */
public class ServiceResult implements Serializable {
    private static final long serialVersionUID = -1L;
    private String resultCode = RestCodeEnum.SUCCESS.getCode();
    private String resultMsg = RestCodeEnum.SUCCESS.getMsg();
    private Object resultObj = null;
    private boolean flag = false;//返回的信息是否展示，true 前端要展示resultMsg
    private String timestamp = LocalDateTime.now().toString();

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ServiceResult() {
    }

    public ServiceResult(String message) {
        this.resultMsg = message;
    }

    public ServiceResult(String code, String message) {
        this.resultCode = code;
        this.resultMsg = message;
    }

    public ServiceResult(RestCodeEnum restCodeEnum) {
        this.resultMsg = restCodeEnum.getMsg();
        this.resultCode = restCodeEnum.getCode();
    }


    public ServiceResult(String code, String message, Object object) {
    }

    public ServiceResult error(String msg, Object object, boolean flag) {
        return this.putFlag(flag).putCode("999999").putMsg(msg).putObject(object);
    }

    /**
     * @param msg
     * @return flag为true的
     */
    public ServiceResult error(String msg) {
        this.setFlag(true);
        this.setResultMsg(msg);
        return this.putFlag(true).putMsg(msg);
    }

    /**
     * @param msg
     * @return flag为true
     */
    public ServiceResult ok(String msg) {
        return this.putFlag(true).putMsg(msg);
    }

    public ServiceResult ok() {
        return this;
    }

    public ServiceResult(Object object) {
        this.resultObj = object;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultObj() {
        return this.resultObj;
    }

    public void setResultObj(Object resultObj) {
        this.resultObj = resultObj;
    }


    public static void main(String[] args) {
        RestCodeEnum success = RestCodeEnum.SUCCESS;
        //时区
        ZonedDateTime now = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(now);
        ServiceResult serviceResult = new ServiceResult();
        ServiceResult serviceResult1 = serviceResult.restCode_ERROR(RestCodeEnum.SUCCESS);
//        serviceResult.putCode("200").putFlag(true).putFlag(false);
        System.out.println(serviceResult);
        ServiceResult serviceResult2 = new ServiceResult(RestCodeEnum.PARAM_IS_INVALID);
        System.out.println(serviceResult2);
        serviceResult2.restCode(RestCodeEnum.RC91000);

        System.out.println(serviceResult2);
    }

    public static void setParams(String... str) {
        if (str.length > 3) {
            return;
        }
        for (int i = 0; i < str.length; i++) {

        }
        System.out.println(str);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultObj=" + resultObj +
                ", flag=" + flag +
                ", timestamp=" + timestamp +
                '}';
    }

    /***********************编程************************************************/
    public ServiceResult putCode(String code) {
        this.setResultCode(code);
        return this;
    }

    public ServiceResult putMsg(String msg) {
        this.setResultMsg(msg);
        return this;
    }

    public ServiceResult putObject(Object object) {
        this.setResultObj(object);
        return this;
    }

    public ServiceResult putFlag(Boolean flag) {
        this.setFlag(flag);
        return this;
    }

    /******************************************************************/
    public ServiceResult restCode_ERROR(RestCodeEnum restCodeEnum) {
        return this.putMsg(restCodeEnum.getMsg()).putCode(restCodeEnum.getCode());
    }

    public ServiceResult restCode_OBJECT(RestCodeEnum restCodeEnum, Object object) {
        return this.putMsg(restCodeEnum.getMsg()).putCode(restCodeEnum.getCode()).putObject(object);
    }

    public ServiceResult restCode(RestCodeEnum restCodeEnum) {
        return this.putMsg(restCodeEnum.getMsg()).putCode(restCodeEnum.getCode());
    }
    /**
     * code = u.getCode();
     * msg = u.getMsg();
     * data = data;
     *
     * @param u
     * @param data
     */
    public static ServiceResult setEnum(CodeEnum u, Object data) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.resultCode = u.getCode();
        serviceResult.resultMsg = u.getMsg();
        serviceResult.flag = u.isFlag();
        serviceResult.resultObj = data;
        return serviceResult;
    }

    /**
     * code = CodeEnum.SUCCESS.getCode();
     * msg = CodeEnum.SUCCESS.getMsg();
     * data = data;
     *
     * @param data
     */
    public static ServiceResult successObject(Object data) {
        ServiceResult serviceResult = ServiceResult.setEnum(CodeEnum.SUCCESS, data);
        return serviceResult;
    }

    /**
     * serviceResult.code = u.getCode();
     * serviceResult.msg = u.getMsg();
     * serviceResult.data = data;
     *
     * @param u
     * @param data
     * @return serviceResult
     */
    public static ServiceResult success(CodeEnum u, Object data) {
        return ServiceResult.setEnum(CodeEnum.SUCCESS, data);
    }

    /**
     * SUCCESS("000000", "成功", false),
     * null
     *
     * @return
     */
    public static ServiceResult defaultSuccess() {
        return ServiceResult.setEnum(CodeEnum.SUCCESS, null);
    }

    /**
     * ERROR("99999", "错误", false),
     * data=null
     *
     * @return
     */
    public static ServiceResult defaultError() {
        return ServiceResult.setEnum(CodeEnum.ERROR, null);
    }

    /**
     * code = u.getCode();
     * msg = u.getMsg();
     * flag=u.isFlag();
     * data=o
     *
     * @param u
     */
    public static ServiceResult error(CodeEnum u, Object o) {
        return ServiceResult.setEnum(u, o);
    }

    /**
     * code = u.getCode();
     * msg = e.getMessage();
     * flag=u.getFlag();
     * data = e
     *
     * @param u
     * @param e
     */
    public static ServiceResult setException(CodeEnum u, Exception e) {
        ServiceResult serviceResult = ServiceResult.setEnum(u, e);
        serviceResult.setResultMsg(e.getMessage());
        return serviceResult;
    }

    /**
     * serviceResult.code = CodeEnum.ERROR.getCode();
     * serviceResult.msg = msg;
     * serviceResult.flag=true;
     * 尽量不要用，用多了代码容易混乱，建议使用MsgEnum来拼接msg
     *
     * @param msg
     * @return
     */
    @Deprecated
    public static ServiceResult setErrorMsg(String msg, boolean flag) {
        ServiceResult serviceResult = ServiceResult.setEnum(CodeEnum.ERROR, null);
        serviceResult.setResultMsg(msg);
        serviceResult.setFlag(flag);
        return serviceResult;
    }

    /**
     * 从数据库中获取的错误码
     * map的形式
     * "msg" -> "未知错误"
     * "code" -> "99922"
     * "flag" -> "1"
     * "system" -> "pokweb"
     *
     * @param map
     * @return
     */
    @Deprecated
    public static ServiceResult setErrorMap(Map<String, String> map) {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultCode(map.get("code"));
        serviceResult.setResultMsg(map.get("msg"));
        serviceResult.setFlag("0".equals(map.get("flag")) ? false : true);
        return serviceResult;
    }
}
