package com.example.eagleeyenetworks.contract;

import com.example.eagleeyenetworks.model.Camera;

import java.util.List;

public interface MainContract {

    interface View {

        void onCameraResponse(List<Camera> cameras);

        void onCameraFailure();

    }

    interface Presenter {
        void cameraCall(String token);
    }
}
