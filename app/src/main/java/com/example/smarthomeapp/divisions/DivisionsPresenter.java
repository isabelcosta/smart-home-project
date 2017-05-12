package com.example.smarthomeapp.divisions;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.divisions.data.DivisionsDataSource;
import com.example.smarthomeapp.divisions.data.DivisionsRepository;
import com.example.utils.domain.Division;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isabelcosta on 06-May-17.
 */

public class DivisionsPresenter implements DivisionsContract.Presenter {

    private final DivisionsRepository mDivisionsRepository;
    private final DivisionsContract.View mDivisionsView;
    private List<Division> mDivisionsList;

    public DivisionsPresenter(@NonNull DivisionsRepository divisionsRepository,
                              @NonNull DivisionsContract.View divisionsView) {
        mDivisionsRepository = divisionsRepository;
        mDivisionsView = divisionsView;
        mDivisionsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadDivisions();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void openDevicesList(int divisionPosition) {

        mDivisionsView.setLoadingIndicator(true);

        final String divisionId = mDivisionsList.get(divisionPosition).getId();

        mDivisionsRepository.getDevices(divisionId, new DivisionsDataSource.LoadDevicesCallback() {
            @Override
            public void onDevicesLoaded(List<DeviceStateResponse> devices) {
                // The view may not be able to handle UI updates anymore
                if (!mDivisionsView.isActive()) {
                    return;
                }
                mDivisionsView.setLoadingIndicator(false);
                mDivisionsView.showDivisionDevicesUi(divisionId, devices);
            }

            @Override
            public void onDataNotAvailable() {
                mDivisionsView.setLoadingIndicator(false);

                // Send empty list
                mDivisionsView.showDivisionDevicesUi(divisionId, new ArrayList<DeviceStateResponse>());
            }
        });
    }

    @Override
    public void loadDivisions() {

        mDivisionsList = SmartHomeApplication
                .getInstance()
                .getHomeConfiguration()
                .getDivisionList();

        mDivisionsView.showDivisions(mDivisionsList);
    }
}
