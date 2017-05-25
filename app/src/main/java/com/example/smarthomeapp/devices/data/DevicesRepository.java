package com.example.smarthomeapp.devices.data;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.divisions.data.DivisionsDataSource;
import com.example.smarthomeapp.divisions.data.DivisionsRepository;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;

import java.util.List;
import java.util.Map;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesRepository implements DevicesDataSource{

    private static DevicesRepository INSTANCE = null;

    private final DevicesDataSource mDevicesRemoteDataSource;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    private DevicesRepository(@NonNull DevicesDataSource devicesRemoteDataSource){
        mDevicesRemoteDataSource = checkNotNull(devicesRemoteDataSource);
    }

    public static DevicesRepository getInstance(DevicesDataSource devicesRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DevicesRepository(devicesRemoteDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getAllDevices(@NonNull final LoadDevicesCallback callback) {
        checkNotNull(callback);

        mDevicesRemoteDataSource.getAllDevices(new LoadDevicesCallback() {
            @Override
            public void onDevicesLoaded(List<DeviceStateResponse> deviceStateResponses) {
                callback.onDevicesLoaded(deviceStateResponses);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void updateDeviceValue(@NonNull Map<String,String> devicesValues, @NonNull UpdateDeviceValueCallback callback) {

    }
}
