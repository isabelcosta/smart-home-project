package com.example.smarthomeapp.util;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.smarthomeapp.devices.data.DevicesRepository;
import com.example.smarthomeapp.devices.data.remote.DevicesRemoteDataSource;
import com.example.smarthomeapp.divisions.data.DivisionsRepository;
import com.example.smarthomeapp.divisions.data.remote.DivisionsRemoteDataSource;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class Injection {

    public static DivisionsRepository provideDivisionsRepository(@NonNull Context context) {
        return DivisionsRepository.getInstance(DivisionsRemoteDataSource.getInstance());
    }

    public static DevicesRepository provideDevicesRepository(@NonNull Context context) {
        return DevicesRepository.getInstance(DevicesRemoteDataSource.getInstance());
    }

//    public static AllControlRepository provideAllControlRepository(@NonNull Context context) {
//        return AllControlRepository.getInstance(AllControlRemoteDataSource.getInstance());
//    }
}
