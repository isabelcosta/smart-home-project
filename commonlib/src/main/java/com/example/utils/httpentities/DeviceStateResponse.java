package com.example.utils.httpentities;

import java.util.List;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class DeviceStateResponse {

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
}
