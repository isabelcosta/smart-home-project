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

    public interface View extends BaseView<DevicesContract.Presenter> {

        void setLoadingIndicator(boolean active);

        void showDevices(List<Device> devices, List<DeviceStateResponse> devicesState);

        void showNoDevices();

        boolean isActive();

        void showFailedUpdate();

        void showSuccessfulUpdate();
    }

    public interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void saveDeviceValue(Map<String,String> devicesValues);

        void loadDevices();

        Map<String,String> getDeviceValuesToSave();

    }
}
