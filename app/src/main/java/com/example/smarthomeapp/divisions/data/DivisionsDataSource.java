package com.example.smarthomeapp.divisions.data;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.httpentities.DeviceStateResponse;

import java.util.List;

/**
 * Created by isabelcosta on 12-May-17.
 */

public interface DivisionsDataSource {

    interface LoadDevicesCallback {

        void onDevicesLoaded(List<DeviceStateResponse> devices);

        void onDataNotAvailable();
    }

    void getDevices(String divisionId, @NonNull DivisionsDataSource.LoadDevicesCallback callback);
}
