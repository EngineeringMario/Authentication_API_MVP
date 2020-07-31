package com.example.eagleeyenetworks.contract;

public interface LoginContract {

    interface View {

       void onLoginSuccess(String token);
        void onLoginFailure(String message);

    }

    interface Presenter {
        void loginCall(String username, String password);

    }
}
