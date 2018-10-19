package com.hu.common;

import java.io.Serializable;

public class Principal implements Serializable {

    private Integer uid;
    private String username; //账号
    private String name;

    public Principal(Integer uid, String username, String name) {
        this.uid = uid;
        this.username = username;
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
