package com.example.eagleeyenetworks.network;

import com.example.eagleeyenetworks.utils.Constants;
import com.example.eagleeyenetworks.model.Camera;
import com.example.eagleeyenetworks.model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Client {

    @GET("rest/v2.4/cameras")
    Call<List<Camera>> getCameras(@Header(Constants.auth) String authToken);


    @POST("oauth/token")
    Call<Token> login(
            @Header("Authorization") String token,
            @Query("username") String username,
            @Query("password") String password,
            @Query("grant_type") String grant_type
    );
}
