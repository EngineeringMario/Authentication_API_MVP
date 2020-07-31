package com.example.eagleeyenetworks.presenter;

import android.util.Log;

import com.example.eagleeyenetworks.contract.MainContract;
import com.example.eagleeyenetworks.model.Camera;
import com.example.eagleeyenetworks.network.Client;
import com.example.eagleeyenetworks.network.RetrofitObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private List<Camera> cameras = new ArrayList<>();

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }






    @Override
    public void cameraCall(String token) {
        Client client = RetrofitObject.baseUrlObject().create(Client.class);
        Call call = client.getCameras("Bearer " + token);
        // a classic and fatal mistake is forgetting the bearer keyword

        call.enqueue(new Callback<List<Camera>>() {
            @Override
            public void onResponse(Call<List<Camera>> call, Response<List<Camera>> response) {
                cameras = response.body();
                Log.i("token", response.body() + token);
                view.onCameraResponse(cameras);




            }

            @Override
            public void onFailure(Call call, Throwable t) {
            Log.i("token", t.getMessage());
            view.onCameraFailure();
            }
        });

    }
}
