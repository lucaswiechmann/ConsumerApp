package com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LucasW on 10/04/2016.
 */
public class Consumer {
    @SerializedName("id")
    private String ID;

    @SerializedName("name")
    private String name;

    @SerializedName("pwd")
    private String pwd;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
