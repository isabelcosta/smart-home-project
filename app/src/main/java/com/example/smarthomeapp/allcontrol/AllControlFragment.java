package com.example.smarthomeapp.allcontrol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.smarthomeapp.BaseFragment;
import com.example.smarthomeapp.R;
import com.example.smarthomeapp.devices.DevicesAdapter;
import com.example.smarthomeapp.devices.DevicesContract;
import com.example.smarthomeapp.devices.DevicesPresenter;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.smarthomeapp.util.Injection;
import com.example.utils.domain.Device;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by isabelcosta on 25-May-17.
 */

public class AllControlFragment extends BaseFragment implements AllControlContract.View{

    private AllControlContract.Presenter mPresenter;
    private DevicesAdapter mAdapter;
    private List<DeviceStateResponse> _devicesStateList;

    @BindView(R.id.devices_loader_view)
    View mLoader;

    @BindView(R.id.devices_container_view)
    View mContainerView;

    @BindView(R.id.devices_list)
    RecyclerView mDevicesRecyclerView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AllControlFragment.
     */
    public static AllControlFragment newInstance() {
        AllControlFragment fragment = new AllControlFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<DeviceStateResponse> devicesStateList = new ArrayList<>();

        // Create the presenter
        mPresenter = new AllControlPresenter(
                devicesStateList,
                Injection.provideDevicesRepository(getContext()),
                this
        );

        mAdapter = new DevicesAdapter(
                getContext(),
                mPresenter,
                new LinkedList<Device>(),
                new LinkedList<DeviceStateResponse>()
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_devices, container, false);
        ButterKnife.bind(this, view);

        mDevicesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Set the adapter
        mDevicesRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void setPresenter(@NonNull AllControlContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        mLoader.setVisibility(active ? View.VISIBLE : View.GONE);
        mContainerView.setVisibility(!active ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showAllDevices(List<Device> devices, List<DeviceStateResponse> deviceStateResponses) {
//        Toast.makeText(getContext(), "HALO  " + deviceStateResponses.size(), Toast.LENGTH_LONG).show();
        mAdapter.replaceData(devices, deviceStateResponses);
    }

    @Override
    public void showNoDevices() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
