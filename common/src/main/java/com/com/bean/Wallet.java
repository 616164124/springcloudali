package com.com.bean;

import java.io.Serializable;

/**
 * wallet
 * @author 
 */
public class Wallet implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    private String userid;

    /**
     * 余额
     */
    private Long sum;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}