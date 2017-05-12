package com.example.smarthomeapp.devices.data;

import android.support.annotation.NonNull;

import com.example.utils.domain.Device;

import java.util.List;

/**
 * Created by isabelcosta on 12-May-17.
 */

public interface DevicesDataSource {

    interface LoadDevicesCallback {

        void onDevicesLoaded(List<Device> devices);

        void onDataNotAvailable();
    }

    interface UpdateDeviceValueCallback {

        void onDeviceValueUpdated(boolean isUpdated);

        void onDataNotAvailable();
    }

    void getDevicesValues(@NonNull LoadDevicesCallback callback);

    void updateDeviceValue(@NonNull Device device, @NonNull UpdateDeviceValueCallback callback);

}
