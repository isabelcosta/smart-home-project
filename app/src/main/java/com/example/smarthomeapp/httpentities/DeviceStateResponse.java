package com.example.smarthomeapp.httpentities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class DeviceStateResponse implements Parcelable {

    public String deviceId;
    public List<PropertyValueResponse> values;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<PropertyValueResponse> getValues() {
        return values;
    }

    public void setValues(List<PropertyValueResponse> values) {
        this.values = values;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.deviceId);
        dest.writeList(this.values);
    }

    public DeviceStateResponse() {
    }

    protected DeviceStateResponse(Parcel in) {
        this.deviceId = in.readString();
        this.values = new ArrayList<PropertyValueResponse>();
        in.readList(this.values, PropertyValueResponse.class.getClassLoader());
    }

    public static final Parcelable.Creator<DeviceStateResponse> CREATOR = new Parcelable.Creator<DeviceStateResponse>() {
        @Override
        public DeviceStateResponse createFromParcel(Parcel source) {
            return new DeviceStateResponse(source);
        }

        @Override
        public DeviceStateResponse[] newArray(int size) {
            return new DeviceStateResponse[size];
        }
    };
}
