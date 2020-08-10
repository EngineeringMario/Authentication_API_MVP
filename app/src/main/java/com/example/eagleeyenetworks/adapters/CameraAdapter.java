package com.example.eagleeyenetworks.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagleeyenetworks.R;
import com.example.eagleeyenetworks.model.Camera;

import java.util.List;

public class CameraAdapter extends RecyclerView.Adapter<CameraAdapter.MyViewHolder> {
    private List<Camera> cameras;
    private onCameraListener onCameraListener;

    public CameraAdapter(@NonNull List<Camera> cameras, onCameraListener onCameraListener) {
        this.onCameraListener = onCameraListener;
        this.cameras = cameras;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.camera_item, parent, false);


        return new MyViewHolder(view, onCameraListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(cameras.get(position));

    }

    @Override
    public int getItemCount() {


        return cameras.size();


    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView cameraName, cameraId, deviceType, macAddress, zoneId, accountId;
        onCameraListener onCameraListener;


        public MyViewHolder(View itemView, onCameraListener onCameraListener) {
            super(itemView);
            cameraName = itemView.findViewById(R.id.name);
            cameraId = itemView.findViewById(R.id.cameraId);
            deviceType = itemView.findViewById(R.id.deviceType);
            macAddress = itemView.findViewById(R.id.macAddress);
            zoneId = itemView.findViewById(R.id.zoneId);
            accountId = itemView.findViewById(R.id.accountId);
            this.onCameraListener = onCameraListener;

            itemView.setOnClickListener(this);
        }

        public void bind(final Camera camera) {
            cameraName.setText("Camera name: " + camera.getName());
            cameraId.setText("Camera ID: " + camera.getCameraId());
            deviceType.setText("Device Type ID: " + camera.getDeviceTypeId());
            macAddress.setText("Mac Address: " + camera.getEthMacAddress());
            zoneId.setText("Zone ID" + camera.getZoneId());
            accountId.setText("Account ID: " + camera.getAccountId());
        }


        @Override
        public void onClick(View v) {
            onCameraListener.onCameraClick(getAdapterPosition(), cameras);

        }
    }

    public interface onCameraListener {
        void onCameraClick(int position, List<Camera> cameras);
    }
}
