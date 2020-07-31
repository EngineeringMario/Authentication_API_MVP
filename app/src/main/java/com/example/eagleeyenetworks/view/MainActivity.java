package com.example.eagleeyenetworks.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.eagleeyenetworks.R;
import com.example.eagleeyenetworks.adapters.CameraAdapter;
import com.example.eagleeyenetworks.contract.MainContract;
import com.example.eagleeyenetworks.model.Camera;
import com.example.eagleeyenetworks.presenter.MainPresenter;

import java.util.List;

import static com.example.eagleeyenetworks.utils.Constants.TOKEN_KEY;

public class MainActivity extends BaseActivity implements MainContract.View, CameraAdapter.onCameraListener {

   private MainContract.Presenter presenter;
   private RecyclerView cameraList;
   private List<Camera> cameras;

    private static final String TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //onlinedemo@cameramanager.com" "demo1234"
        cameraList = findViewById(R.id.list);

        presenter = new MainPresenter(this);

        initSharedPreferencesEncrypted();

        initGetCameras();

    }





    private void initGetCameras() {
         String token = sharedPreferences.getString(TOKEN_KEY, null);
         if(token != null)
        presenter.cameraCall(token);
    }



    @Override
    public void onCameraResponse(List<Camera> cameras) {
        CameraAdapter cameraAdapter = new CameraAdapter(cameras, this);
        cameraList.setAdapter(cameraAdapter);
        cameraList.setLayoutManager(new LinearLayoutManager(
                MainActivity.this

        ));


     //   Log.i(TAG, "onCameraResponse: " + cameras);

    }


    @Override
    public void onCameraFailure() {

        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onCameraClick(int position, List<Camera> cameras) {
        Intent intent = new Intent(MainActivity.this, CameraParcel.class);
        intent.putExtra("Camera Item", cameras.get(position) );
        startActivity(intent);

        Log.d(TAG, "onCameraClick: clicked");

    }
}