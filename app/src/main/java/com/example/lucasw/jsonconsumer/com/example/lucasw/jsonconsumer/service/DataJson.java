package com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LucasW on 10/04/2016.
 */
public class DataJson {
    @SerializedName("data")
    public List<Consumer> consumers;

    DataJson() {
        consumers = new ArrayList<>();
    }

}
