package com.example.smarthomeapp.httpentities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class DevicesResponse implements Parcelable {

    public List<DeviceStateResponse> devicesValues;

    public DevicesResponse(List<DeviceStateResponse> devicesValues) {
        this.devicesValues = devicesValues;
    }

    public List<DeviceStateResponse> getDevicesValues() {
        return devicesValues;
    }

    public void setDevicesValues(List<DeviceStateResponse> devicesValues) {
        this.devicesValues = devicesValues;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.devicesValues);
    }

    protected DevicesResponse(Parcel in) {
        this.devicesValues = in.createTypedArrayList(DeviceStateResponse.CREATOR);
    }

    public static final Parcelable.Creator<DevicesResponse> CREATOR = new Parcelable.Creator<DevicesResponse>() {
        @Override
        public DevicesResponse createFromParcel(Parcel source) {
            return new DevicesResponse(source);
        }

        @Override
        public DevicesResponse[] newArray(int size) {
            return new DevicesResponse[size];
        }
    };
}
