package com.example.smarthomeapp.allcontrol;

import com.example.smarthomeapp.BasePresenter;
import com.example.smarthomeapp.BaseView;
import com.example.smarthomeapp.devices.DevicesContract;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;

import java.util.List;

/**
 * Created by isabelcosta on 25-May-17.
 */

public class AllControlContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showAllDevices(List<Device> devices, List<DeviceStateResponse> devicesState);

        void showNoDevices();

        boolean isActive();
    }

    public interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadAllDevices();
    }

}
