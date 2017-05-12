package com.example.smarthomeapp.devices;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.smarthomeapp.BaseFragment;
import com.example.smarthomeapp.R;
import com.example.smarthomeapp.divisions.DivisionsAdapter;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.smarthomeapp.util.Injection;
import com.example.utils.domain.Device;
import com.example.utils.domain.Division;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DevicesFragment extends BaseFragment implements DevicesContract.View{

    private DevicesContract.Presenter mPresenter;

    private DivisionsAdapter mAdapter;

    public static String DEVICES_STATES_ARG = "DEVICES_STATES_ARG";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DivisionsFragment.
     */
    public static DevicesFragment newInstance(List<DeviceStateResponse> deviceStateResponses) {
        DevicesFragment fragment = new DevicesFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(DEVICES_STATES_ARG, new ArrayList<Parcelable>(deviceStateResponses));
        fragment.setArguments(args);
        return fragment;
    }

    public DevicesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<DeviceStateResponse> mDevicesList = new ArrayList<>();
        if (getArguments() != null) {
            mDevicesList = getArguments().getParcelableArrayList(DEVICES_STATES_ARG);
        }

        // Create the presenter
        mPresenter = new DevicesPresenter(
                mDevicesList,
                Injection.provideDevicesRepository(getContext()),
                this
        );

        mAdapter = new DivisionsAdapter(getContext(), mPresenter, new ArrayList<Division>(0));
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devices, container, false);
    }

    @Override
    public void setPresenter(DevicesContract.Presenter presenter) {

    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showDevices(List<Device> devices, List<DeviceStateResponse> deviceStateResponses) {
        Toast.makeText(getContext(), "HALO  " + deviceStateResponses.size(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNoDevices() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
