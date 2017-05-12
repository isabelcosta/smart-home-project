package com.example.smarthomeapp.devices;

import com.example.smarthomeapp.BasePresenter;
import com.example.smarthomeapp.BaseView;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesContract {

    interface View extends BaseView<DevicesContract.Presenter> {

        void setLoadingIndicator(boolean active);

        void showDevices(Map<String, Device> devices, Map<String, DeviceStateResponse> devicesState);

        void showNoDevices();

        boolean isActive();

        void showFailedUpdate();

        void showSuccessfulUpdate();
    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void saveDeviceValue(Map<String,String> devicesValues);

        void loadDevices();

        Map<String,String> getDeviceValuesToSave();

    }
}
