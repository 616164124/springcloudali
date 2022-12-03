package com.com.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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
}
