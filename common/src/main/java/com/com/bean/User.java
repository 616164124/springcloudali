package com.com.bean;

import java.io.Serializable;

public class User implements Serializable  {
    private final static long serialVersionUID = 1L;
    private String pokid;
    private String username;
    private String password;

    public User(String pokid, String username, String password) {
        this.pokid = pokid;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getPokid() {
        return pokid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPokid(String s) {
        this.pokid=s;
    }

    @Override
    public String toString() {
        return "User{" +
                "pokid='" + pokid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
