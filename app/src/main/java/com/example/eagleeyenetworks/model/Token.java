package com.example.eagleeyenetworks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {


    @SerializedName("access_token")
    @Expose
    private String access_token;

    public String getAccessToken() {
        return access_token;
    }
}
