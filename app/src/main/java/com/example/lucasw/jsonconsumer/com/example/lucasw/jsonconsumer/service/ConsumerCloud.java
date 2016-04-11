package com.example.lucasw.jsonconsumer.com.example.lucasw.jsonconsumer.service;

import retrofit.RestAdapter;

/**
 * Created by LucasW on 10/04/2016.
 */
public class ConsumerCloud {
    private static final String API_URL = "https://s3-sa-east-1.amazonaws.com";

    public static final RestAdapter RETROFIT = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .build();

    private static final ConsumerService SERVICE = RETROFIT.create(ConsumerService.class);

    public static ConsumerService getService() {
        return SERVICE;
    }
}
