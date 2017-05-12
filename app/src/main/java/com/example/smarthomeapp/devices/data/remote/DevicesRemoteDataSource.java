package com.example.smarthomeapp.devices.data.remote;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.devices.data.DevicesDataSource;
import com.example.smarthomeapp.divisions.data.remote.DivisionsService;
import com.example.smarthomeapp.util.Constants;
import com.example.smarthomeapp.util.RemoteUtils;
import com.example.utils.domain.Device;

import java.util.Map;

import retrofit2.Retrofit;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesRemoteDataSource implements DevicesDataSource {

    private static DevicesRemoteDataSource INSTANCE;
    DevicesService _service;
    Retrofit _retrofit = RemoteUtils.getRetrofitObj();

    public static DevicesRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DevicesRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private DevicesRemoteDataSource() {
        // Create a very simple REST adapter which points the SmartHomeApp API endpoint.
        _service = _retrofit.create(DevicesService.class);
    }

    @Override
    public void getDevicesValues(@NonNull LoadDevicesCallback callback) {

    }

    @Override
    public void updateDeviceValue(@NonNull Map<String, String> devicesValues, @NonNull UpdateDeviceValueCallback callback) {
//        // Fetch a list of the division devices repositories.
//        Call<List<DeviceStateResponse>> devicesCall = _service.getDevices(divisionId);
//
//        // Execute the call asynchronously. Get a positive or negative callback.
//        devicesCall.enqueue(new Callback<List<DeviceStateResponse>>() {
//            @Override
//            public void onResponse(Call<List<DeviceStateResponse>> call, Response<List<DeviceStateResponse>> response) {
//                // The network call was a success and we got a response
//                List<DeviceStateResponse> devices = response.body();
//                callback.onDevicesLoaded(devices);
//            }
//
//            @Override
//            public void onFailure(Call<List<DeviceStateResponse>> call, Throwable t) {
//                // the network call was a failure
//                callback.onDataNotAvailable();
//            }
//        });
    }
}
