package com.example.server.httpentities;

import java.util.List;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class DevicesResponse {

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
}
