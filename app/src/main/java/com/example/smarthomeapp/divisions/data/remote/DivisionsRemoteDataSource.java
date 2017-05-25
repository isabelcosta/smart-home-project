package com.example.smarthomeapp.divisions.data.remote;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.divisions.data.DivisionsDataSource;
import com.example.smarthomeapp.util.RemoteUtils;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DivisionsRemoteDataSource implements DivisionsDataSource{

    private static DivisionsRemoteDataSource INSTANCE;
    DivisionsService _service;
    Retrofit _retrofit = RemoteUtils.getRetrofitObj();

    public static DivisionsRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DivisionsRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private DivisionsRemoteDataSource() {

        // Create a very simple REST adapter which points the SmartHomeApp API endpoint.
        _service = _retrofit.create(DivisionsService.class);
    }

    @Override
    public void getDevices(String divisionId, @NonNull final LoadDevicesCallback callback) {
        // Fetch a list of the division devices repositories.
        Call<List<DeviceStateResponse>> devicesCall = _service.getDevicesByDivision(divisionId);

        // Execute the call asynchronously. Get a positive or negative callback.
        devicesCall.enqueue(new Callback<List<DeviceStateResponse>>() {
            @Override
            public void onResponse(Call<List<DeviceStateResponse>> call, Response<List<DeviceStateResponse>> response) {
                // The network call was a success and we got a response
                List<DeviceStateResponse> devices = response.body();
                callback.onDevicesLoaded(devices);
            }

            @Override
            public void onFailure(Call<List<DeviceStateResponse>> call, Throwable t) {
                // the network call was a failure
                callback.onDataNotAvailable();
            }
        });
    }
}
