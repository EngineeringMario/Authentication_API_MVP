package com.example.eagleeyenetworks.presenter;

import android.util.Log;

import com.example.eagleeyenetworks.utils.Constants;
import com.example.eagleeyenetworks.contract.LoginContract;
import com.example.eagleeyenetworks.model.Token;
import com.example.eagleeyenetworks.network.Client;
import com.example.eagleeyenetworks.network.RetrofitObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {


    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;

    }


    @Override
    public void loginCall(String username, String password) {

        Client client = RetrofitObject.baseUrlObject().create(Client.class);
        Call call = client.login("Basic " + Constants.API_KEY, username, password, "password");
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                view.onLoginSuccess(response.body().getAccessToken());

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("token", t.getMessage());
                view.onLoginFailure(t.getMessage());

            }
        });
    }

}
