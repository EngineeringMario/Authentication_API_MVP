package com.example.eagleeyenetworks.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    private static Retrofit retrofit;

    public static Retrofit baseUrlObject() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl("https://rest.cameramanager.com/").
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }

        return retrofit;
    }



}
