package com.example.eagleeyenetworks.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Camera implements Parcelable {


    @SerializedName("cameraId")
    @Expose
    private Integer cameraId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("deviceTypeId")
    @Expose
    private Integer deviceTypeId;
    @SerializedName("ethMacAddress")
    @Expose
    private String ethMacAddress;

    @SerializedName("zoneId")
    @Expose
    private Integer zoneId;
    @SerializedName("accountId")
    @Expose
    private Integer accountId;

    protected Camera(Parcel in) {
        if (in.readByte() == 0) {
            cameraId = null;
        } else {
            cameraId = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            deviceTypeId = null;
        } else {
            deviceTypeId = in.readInt();
        }
        ethMacAddress = in.readString();
        if (in.readByte() == 0) {
            zoneId = null;
        } else {
            zoneId = in.readInt();
        }
        if (in.readByte() == 0) {
            accountId = null;
        } else {
            accountId = in.readInt();
        }
    }

    public static final Creator<Camera> CREATOR = new Creator<Camera>() {
        @Override
        public Camera createFromParcel(Parcel in) {
            return new Camera(in);
        }

        @Override
        public Camera[] newArray(int size) {
            return new Camera[size];
        }
    };

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getEthMacAddress() {
        return ethMacAddress;
    }

    public void setEthMacAddress(String ethMacAddress) {
        this.ethMacAddress = ethMacAddress;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "cameraId=" + cameraId +
                ", name='" + name + '\'' +
                ", deviceTypeId=" + deviceTypeId +
                ", ethMacAddress='" + ethMacAddress + '\'' +
                ", zoneId=" + zoneId +
                ", accountId=" + accountId +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (cameraId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cameraId);
        }
        dest.writeString(name);
        if (deviceTypeId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(deviceTypeId);
        }
        dest.writeString(ethMacAddress);
        if (zoneId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(zoneId);
        }
        if (accountId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(accountId);
        }
    }
}
