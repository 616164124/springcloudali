package com.com.response;

/**
 *encoded: UTF-8
 *
 * 消息进行拼接的时候用到
 */
public enum MsgEnum {
    msg01("你好","先生\\女士"),
    SUCCESS("启动成功==》","端口："),


    ;
    private String msg_1;
    private String msg_2;

    MsgEnum(String msg_1, String msg_2) {
        this.msg_1 = msg_1;
        this.msg_2 = msg_2;
    }


    public String getMsg_1() {
        return msg_1;
    }

    public void setMsg_1(String msg_1) {
        this.msg_1 = msg_1;
    }

    public String getMsg_2() {
        return msg_2;
    }

    public void setMsg_2(String msg_2) {
        this.msg_2 = msg_2;
    }
}
