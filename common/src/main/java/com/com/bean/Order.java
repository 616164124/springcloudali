package com.com.bean;

import java.io.Serializable;

/**
 * order
 * @author
 */
public class Order implements Serializable {
    /**
     * 订单id
     */
    private String id;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 产品
     */
    private String product;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}