package com.example.smarthomeapp.devices.data;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.divisions.data.DivisionsDataSource;
import com.example.smarthomeapp.divisions.data.DivisionsRepository;
import com.example.utils.domain.Device;

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
    public void getDevicesValues(@NonNull LoadDevicesCallback callback) {

    }

    @Override
    public void updateDeviceValue(@NonNull Device device, @NonNull UpdateDeviceValueCallback callback) {

    }
}
