package com.example.eagleeyenetworks.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eagleeyenetworks.R;
import com.example.eagleeyenetworks.contract.LoginContract;
import com.example.eagleeyenetworks.presenter.LoginPresenter;

import static com.example.eagleeyenetworks.utils.Constants.TOKEN_KEY;

public class LoginActivity extends BaseActivity implements LoginContract.View {
    private EditText email, password;
    private Button login;

    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initSharedPreferencesEncrypted();
      // checkForPreviousLogin();
        initViews();
        loginPresenter = new LoginPresenter(this);
    }


    //TODO: need to implement a function to determine whether a token is expired
//    private void checkForPreviousLogin() {
//        if (sharedPreferences.getString(TOKEN_KEY, null) != null) {
//            // there is another session open
//            startMainActivity();
//        }
//    }



    private void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }






    private void initViews() {
        email = findViewById(R.id.userName_edittext);
        password = findViewById(R.id.pass_edittext);
        login = findViewById(R.id.button2);

    }

    public void buttonClick(View view) {
        String userName = email.getText().toString();
        String pass = password.getText().toString();
        if (!validate(userName, pass)) return;

        loginPresenter.loginCall(userName, pass);

    }

    private boolean validate(String userName, String pass) {
        if (userName.trim().isEmpty() || pass.trim().isEmpty()) {
            Toast.makeText(this, getString(R.string.error_empty_fields), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public void onLoginSuccess(String token) {
        sharedPreferences.edit()
                .putString(TOKEN_KEY, token)
                .apply();
        startMainActivity();
    }

    @Override
    public void onLoginFailure(String message) {
        Toast.makeText(this, getString(R.string.error_login_msg), Toast.LENGTH_LONG).show();

    }
}

