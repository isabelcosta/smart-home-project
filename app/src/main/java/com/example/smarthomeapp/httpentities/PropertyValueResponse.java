package com.example.smarthomeapp.httpentities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class PropertyValueResponse implements Parcelable {

    public String propertyId;
    public String propertyValue;

    public PropertyValueResponse(String propertyId, String propertyValue) {
        this.propertyId = propertyId;
        this.propertyValue = propertyValue;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.propertyId);
        dest.writeString(this.propertyValue);
    }

    protected PropertyValueResponse(Parcel in) {
        this.propertyId = in.readString();
        this.propertyValue = in.readString();
    }

    public static final Parcelable.Creator<PropertyValueResponse> CREATOR = new Parcelable.Creator<PropertyValueResponse>() {
        @Override
        public PropertyValueResponse createFromParcel(Parcel source) {
            return new PropertyValueResponse(source);
        }

        @Override
        public PropertyValueResponse[] newArray(int size) {
            return new PropertyValueResponse[size];
        }
    };
}
