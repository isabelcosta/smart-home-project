package com.example.smarthomeapp.devices;

import com.example.smarthomeapp.BasePresenter;
import com.example.smarthomeapp.BaseView;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;

import java.util.List;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesContract {

    interface View extends BaseView<DevicesContract.Presenter> {

        void setLoadingIndicator(boolean active);

        void showDevices(List<Device> devices, List<DeviceStateResponse> deviceStateResponses);

        void showNoDevices();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void saveDeviceValue(String deviceId, String value);

        void loadDevices();

    }
}
