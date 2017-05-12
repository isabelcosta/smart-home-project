package com.example.smarthomeapp.devices.data.remote;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.devices.data.DevicesDataSource;
import com.example.smarthomeapp.divisions.data.remote.DivisionsService;
import com.example.smarthomeapp.util.Constants;
import com.example.smarthomeapp.util.RemoteUtils;
import com.example.utils.domain.Device;

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
    public void updateDeviceValue(@NonNull Device device, @NonNull UpdateDeviceValueCallback callback) {

    }

}
