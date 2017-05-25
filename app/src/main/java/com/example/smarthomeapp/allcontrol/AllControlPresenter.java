package com.example.smarthomeapp.allcontrol;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.devices.DevicesContract;
import com.example.smarthomeapp.devices.data.DevicesDataSource;
import com.example.smarthomeapp.devices.data.DevicesRepository;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by isabelcosta on 25-May-17.
 */

public class AllControlPresenter implements AllControlContract.Presenter {

    private final DevicesRepository mDevicesRepository;
    private final AllControlContract.View mAllControlView;

    private List<DeviceStateResponse> mDevicesStateResponsesList;
    private List<Device> mLoadedDevicesList;
    private List<Device> mDevicesList = new LinkedList<>();
    private List<DeviceStateResponse> mDevicesStateList = new LinkedList<>();


    public AllControlPresenter(List<DeviceStateResponse> deviceStateResponses,
                               @NonNull DevicesRepository devicesRepository,
                               @NonNull AllControlContract.View allControlView){
        mDevicesStateResponsesList = deviceStateResponses;
        mLoadedDevicesList = SmartHomeApplication
                .getInstance()
                .getHomeConfiguration()
                .getDevicesList();
        mDevicesRepository = devicesRepository;
        mAllControlView = allControlView;
        mAllControlView.setPresenter(this);
    }

    @Override
    public void start() {
        loadAllDevices();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadAllDevices() {

        mAllControlView.setLoadingIndicator(true);

        mDevicesRepository.getAllDevices(new DevicesDataSource.LoadDevicesCallback() {
            @Override
            public void onDevicesLoaded(List<DeviceStateResponse> devicesState) {
                // The view may not be able to handle UI updates anymore
                if (!mAllControlView.isActive()) {
                    return;
                }
                mAllControlView.setLoadingIndicator(false);
                List<Device> devicesList = SmartHomeApplication
                        .getInstance()
                        .getHomeConfiguration()
                        .getDevicesList();
                mAllControlView.showAllDevices(devicesList, devicesState);
            }

            @Override
            public void onDataNotAvailable() {
                mAllControlView.setLoadingIndicator(false);

                // Send empty list
                mAllControlView.showAllDevices(new ArrayList<Device>(), new ArrayList<DeviceStateResponse>());
            }
        });

        indexDevicesAndStates();
        mAllControlView.setLoadingIndicator(false);
        mAllControlView.showAllDevices(mDevicesList, mDevicesStateList);
    }

    private void indexDevicesAndStates(){

        for(DeviceStateResponse state : mDevicesStateResponsesList){
            String id = state.getDeviceId();
            mDevicesStateList.add(state);

            for(Device device : mLoadedDevicesList){
                if (device.getId().equals(id)){
                    mDevicesList.add(device);
                }
            }
        }
    }
}
