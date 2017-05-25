package com.example.smarthomeapp.divisions.data.remote;

import com.example.smarthomeapp.httpentities.DeviceStateResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by isabelcosta on 12-May-17.
 */

public interface DivisionsService {

    @GET("divisions/{id}/devices")
    Call<List<DeviceStateResponse>> getDevicesByDivision(@Path("id") String id);
}
