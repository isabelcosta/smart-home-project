package com.example.smarthomeapp.devices.data.remote;

import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.smarthomeapp.httpentities.DevicesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

/**
 * Created by isabelcosta on 12-May-17.
 */

public interface DevicesService {

    @GET("devices")
    Call<DevicesResponse> listDevices();

    @PUT("devices/{id}")
    Call<List<DeviceStateResponse>> saveDeviceValue();

}
