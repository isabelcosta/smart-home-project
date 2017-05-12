package com.example.smarthomeapp.devices;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.devices.data.DevicesRepository;
import com.example.smarthomeapp.divisions.DivisionsContract;
import com.example.smarthomeapp.divisions.data.DivisionsRepository;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;
import com.example.utils.domain.Division;

import java.util.List;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesPresenter implements DevicesContract.Presenter{

    private final DevicesRepository mDevicesRepository;
    private final DevicesContract.View mDevicesView;

    private List<Device> mDevicesList;
    private List<DeviceStateResponse> mDevicesStateResponsesList;

    public DevicesPresenter(List<DeviceStateResponse> deviceStateResponses,
                            @NonNull DevicesRepository devicesRepository,
                            @NonNull DevicesContract.View divisionsView) {
        mDevicesStateResponsesList = deviceStateResponses;
        mDevicesList = SmartHomeApplication
                .getInstance()
                .getHomeConfiguration()
                .getDeviceList();
        mDevicesRepository = devicesRepository;
        mDevicesView = divisionsView;
        mDevicesView.setPresenter(this);
    }

    @Override
    public void start() {
        loadDevices();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void saveDeviceValue(String deviceId, String value) {
//        mDevicesView.setLoadingIndicator(true);

    }

    @Override
    public void loadDevices() {
        mDevicesView.showDevices(mDevicesList, mDevicesStateResponsesList);
    }
}
