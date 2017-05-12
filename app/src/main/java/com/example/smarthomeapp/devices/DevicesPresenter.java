package com.example.smarthomeapp.devices;

import android.content.DialogInterface;
import android.support.annotation.NonNull;

import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.devices.data.DevicesDataSource;
import com.example.smarthomeapp.devices.data.DevicesRepository;
import com.example.smarthomeapp.divisions.DivisionsContract;
import com.example.smarthomeapp.divisions.data.DivisionsRepository;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;
import com.example.utils.domain.Division;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesPresenter implements DevicesContract.Presenter{

    private final DevicesRepository mDevicesRepository;
    private final DevicesContract.View mDevicesView;

    private Map<String,String> mDevicesValuesToSave;
    private List<Device> mDevicesList;
    private List<DeviceStateResponse> mDevicesStateResponsesList;

    private Map<String, Device> mDevicesMap = new HashMap<>();
    private Map<String, DeviceStateResponse> mDevicesStateMap = new HashMap<>();

    public DevicesPresenter(List<DeviceStateResponse> deviceStateResponses,
                            String divisionId,
                            @NonNull DevicesRepository devicesRepository,
                            @NonNull DevicesContract.View divisionsView) {
        mDevicesStateResponsesList = deviceStateResponses;
        mDevicesList = SmartHomeApplication
                .getInstance()
                .getHomeConfiguration()
                .getDevicesByDivisionID(divisionId);
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
    public void saveDeviceValue(Map<String,String> devicesValues) {
        mDevicesView.setLoadingIndicator(true);

        mDevicesRepository.updateDeviceValue(devicesValues, new DevicesDataSource.UpdateDeviceValueCallback(){

            @Override
            public void onDeviceValueUpdated(boolean isUpdated) {

                mDevicesView.setLoadingIndicator(false);
                mDevicesView.showSuccessfulUpdate();
            }

            @Override
            public void onDataNotAvailable() {

                mDevicesView.setLoadingIndicator(false);
                mDevicesView.showFailedUpdate();
            }
        });
    }

    @Override
    public void loadDevices() {

        indexDevicesAndStates();
        mDevicesView.setLoadingIndicator(false);
        mDevicesView.showDevices(mDevicesMap, mDevicesStateMap);
    }

    @Override
    public Map<String,String> getDeviceValuesToSave() {
        return mDevicesValuesToSave;
    }

    private void indexDevicesAndStates(){

        for(DeviceStateResponse state : mDevicesStateResponsesList){
            String id = state.getDeviceId();
            mDevicesStateMap.put(id, state);

            for(Device device : mDevicesList){
                if (device.getId().equals(id)){
                    mDevicesMap.put(id, device);
                }
            }
        }


    }

}
