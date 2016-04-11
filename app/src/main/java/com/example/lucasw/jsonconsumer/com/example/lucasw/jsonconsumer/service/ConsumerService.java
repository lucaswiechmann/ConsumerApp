package com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by LucasW on 10/04/2016.
 */
public interface ConsumerService {

    @GET("/pontotel-docs/data.json")
    public void getConsumers(Callback<DataJson> cb);
}
