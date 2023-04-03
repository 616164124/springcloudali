package com.mk.common;


import java.io.Serializable;
import java.util.Map;

/**
 * @author mikael
 * @date 2020-12-13
 * @Description: 返回数据统一格式
 */
public class ServiceResult implements Serializable {

    private static final long serialVersionUID = -1L;
    private String code = CodeEnum.SUCCESS.getCode();
    private String msg = CodeEnum.SUCCESS.getMsg();
    private Object data = null;
    /**
     * 返回的信息是否展示;true 前端要展示msg中的内容
     */
    private boolean flag = false;


    public ServiceResult() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "ServiceResult==>{" +
                "code=\"" + code + "\"" +
                ", msg=\"" + msg + "\"" +
                ", data=" + data +
                ", flag=" + flag +
                "}";
    }

    /*******************************************************/

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
        serviceResult.code = u.getCode();
        serviceResult.msg = u.getMsg();
        serviceResult.flag = u.isFlag();
        serviceResult.data = data;
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
        return ServiceResult.setEnum(u, data);
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
        serviceResult.setMsg(e.getMessage());
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
        serviceResult.setMsg(msg);
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
        serviceResult.setCode(map.get("code"));
        serviceResult.setMsg(map.get("msg"));
        serviceResult.setFlag("0".equals(map.get("flag")) ? false : true);
        return serviceResult;
    }


    public static void main(String[] args) {

        System.out.println(ServiceResult.setErrorMsg("shfjks", false));
        System.out.println(ServiceResult.setException(CodeEnum.Exception, new RuntimeException("skjfl")));
    }
}
