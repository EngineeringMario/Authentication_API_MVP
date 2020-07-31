package com.example.eagleeyenetworks.view;

import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static com.example.eagleeyenetworks.utils.Constants.PREFERENCES_NAME;

public class BaseActivity extends AppCompatActivity {
    protected SharedPreferences sharedPreferences;
    //TODO: change to keystoremanager

   protected void initSharedPreferencesEncrypted()  {
        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
        String masterKeyAlias;
        try {
            masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec);
            sharedPreferences = EncryptedSharedPreferences
                    .create(
                            PREFERENCES_NAME,
                            masterKeyAlias,
                            BaseActivity.this,
                            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                    );
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
