package com.example.eagleeyenetworks.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eagleeyenetworks.R;
import com.example.eagleeyenetworks.model.Camera;

public class CameraParcel extends AppCompatActivity {
    TextView cameraName, cameraId, deviceType, macAddress, zoneId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_parcel);

        cameraName = findViewById(R.id.textView);
        cameraId = findViewById(R.id.textView2);
        deviceType = findViewById(R.id.textView3);
        macAddress = findViewById(R.id.textView4);
        zoneId = findViewById(R.id.textView5);

        Intent intent = getIntent();
        Camera camera = intent.getParcelableExtra("Camera Item");

        String str_cameraName = camera.getName();
        int int_cameraId = camera.getCameraId();
        int int_deviceType = camera.getDeviceTypeId();
        String str_macAddress = camera.getEthMacAddress();
        int int_zoneId = camera.getZoneId();



        cameraName.setText("Camera name: " + str_cameraName);
        cameraId.setText("Camera ID: "+int_cameraId);
        deviceType.setText("Device Type: "+int_deviceType);
        macAddress.setText("Mac Address: " + str_macAddress);
        zoneId.setText("Zone ID: "+int_zoneId);




    }
}