package com.com.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * wl
 *
 * @author
 */
public class Wl implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String id;

    /**
     * 寄件人电话
     */
    private String jjrdh;

    /**
     * 寄件人地址
     */
    private String jjrdz;

    /**
     * 寄件人
     */
    private String jjr;

    /**
     * 寄件日期
     */
    private Date jsrq;

    /**
     * 收件人地址
     */
    private String sjrdz;

    /**
     * 收件人电话
     */
    private String sjrdh;

    /**
     * 收件人
     */
    private String sjr;

    /**
     * 收件日期
     */
    private Date llrq;

    /**
     * 快递状态
     * 0表示快递没有完成
     * 1表示快递已经完成
     */
    private String zt;

    /**
     * 物流公司id
     */
    private String wlgsid;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJjrdh() {
        return jjrdh;
    }

    public void setJjrdh(String jjrdh) {
        this.jjrdh = jjrdh;
    }

    public String getJjrdz() {
        return jjrdz;
    }

    public void setJjrdz(String jjrdz) {
        this.jjrdz = jjrdz;
    }

    public String getJjr() {
        return jjr;
    }

    public void setJjr(String jjr) {
        this.jjr = jjr;
    }

    public Date getJsrq() {
        return jsrq;
    }

    public void setJsrq(Date jsrq) {
        this.jsrq = jsrq;
    }

    public String getSjrdz() {
        return sjrdz;
    }

    public void setSjrdz(String sjrdz) {
        this.sjrdz = sjrdz;
    }

    public String getSjrdh() {
        return sjrdh;
    }

    public void setSjrdh(String sjrdh) {
        this.sjrdh = sjrdh;
    }

    public String getSjr() {
        return sjr;
    }

    public void setSjr(String sjr) {
        this.sjr = sjr;
    }

    public Date getLlrq() {
        return llrq;
    }

    public void setLlrq(Date llrq) {
        this.llrq = llrq;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getWlgsid() {
        return wlgsid;
    }

    public void setWlgsid(String wlgsid) {
        this.wlgsid = wlgsid;
    }
}