package com.example.smarthomeapp.httpentities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class EventResponse implements Parcelable {

    public String userId;
    public String deviceId;
    public String divisionId;
    public String deviceValue;
    public String propertyId;
    public String timeStamp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(String deviceValue) {
        this.deviceValue = deviceValue;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public EventResponse() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userId);
        dest.writeString(this.deviceId);
        dest.writeString(this.divisionId);
        dest.writeString(this.deviceValue);
        dest.writeString(this.propertyId);
        dest.writeString(this.timeStamp);
    }

    protected EventResponse(Parcel in) {
        this.userId = in.readString();
        this.deviceId = in.readString();
        this.divisionId = in.readString();
        this.deviceValue = in.readString();
        this.propertyId = in.readString();
        this.timeStamp = in.readString();
    }

    public static final Creator<EventResponse> CREATOR = new Creator<EventResponse>() {
        @Override
        public EventResponse createFromParcel(Parcel source) {
            return new EventResponse(source);
        }

        @Override
        public EventResponse[] newArray(int size) {
            return new EventResponse[size];
        }
    };
}
