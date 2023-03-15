package com.com.response;


import java.util.HashMap;

/**
 * 返回的类型为HashMap，可以新增多个键值对
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = -1L;

    public Result() {
        put("code", CodeEnum.SUCCESS.getCode());
        put("msg", CodeEnum.SUCCESS.getMsg());
        put("data", null);
    }

    public Result(CodeEnum u) {
        put("code", u.getCode());
        put("msg", u.getMsg());
        put("data", null);
    }

    public static Result putEnum(CodeEnum u, Object o) {
        Result result = new Result();
        result.put("code", u.getCode());
        result.put("msg", u.getMsg());
        result.put("data", o);
        return result;
    }

    /**
     * 新增一个 Key Value
     *
     * @param u     codeEnum
     * @param key   Key
     * @param value object
     * @return result
     */
    public static Result addKV(CodeEnum u, Object o, String key, Object value) {
        Result result = Result.putEnum(u, o);
        result.put(key, value);
        return result;
    }

}
