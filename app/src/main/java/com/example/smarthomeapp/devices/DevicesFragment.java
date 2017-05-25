package com.example.smarthomeapp.devices;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smarthomeapp.BaseFragment;
import com.example.smarthomeapp.R;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.smarthomeapp.util.Injection;
import com.example.utils.domain.Device;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class DevicesFragment extends BaseFragment implements DevicesContract.View{

    private DevicesContract.Presenter mPresenter;

    private DevicesAdapter mAdapter;

    private String mDivisionId;

    public static String DEVICES_STATES_ARG = "DEVICES_STATES_ARG";
    public static String DIVISION_ID_ARG = "DIVISION_ID_ARG";

    @BindView(R.id.devices_loader_view)
    View mLoader;

    @BindView(R.id.empty_state_view)
    View mNoDevicesView;
    @BindView(R.id.empty_state_icon)
    ImageView mEmptyStateIcon;
    @BindView(R.id.empty_state_text)
    TextView mEmptyStateText;

    @BindView(R.id.devices_container_view)
    View mContainerView;

    @BindView(R.id.devices_list)
    RecyclerView mDevicesRecyclerView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DivisionsFragment.
     */
    public static DevicesFragment newInstance(String divisionId, List<DeviceStateResponse> deviceStateResponses) {
        DevicesFragment fragment = new DevicesFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(DEVICES_STATES_ARG, new ArrayList<Parcelable>(deviceStateResponses));
        args.putString(DIVISION_ID_ARG, divisionId);
        fragment.setArguments(args);
        return fragment;
    }

    public DevicesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<DeviceStateResponse> devicesStateList = new ArrayList<>();
        if (getArguments() != null) {
            devicesStateList = getArguments().getParcelableArrayList(DEVICES_STATES_ARG);
            mDivisionId = getArguments().getString(DIVISION_ID_ARG);
        }

        // Create the presenter
        mPresenter = new DevicesPresenter(
                devicesStateList,
                Injection.provideDevicesRepository(getContext()),
                this,
                mDivisionId
        );

        mAdapter = new DevicesAdapter(
                getContext(),
                mPresenter,
                new LinkedList<Device>(),
                new LinkedList<DeviceStateResponse>()
        );
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
        View view = inflater.inflate(R.layout.fragment_devices, container, false);
        ButterKnife.bind(this, view);

        mDevicesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Set the adapter
        mDevicesRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void setPresenter(DevicesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        mLoader.setVisibility(active ? View.VISIBLE : GONE);
        mContainerView.setVisibility(!active ? View.VISIBLE : GONE);
    }

    @Override
    public void showDevices(List<Device> devices, List<DeviceStateResponse> deviceStateResponses) {
        Toast.makeText(getContext(), "HALO  " + deviceStateResponses.size(), Toast.LENGTH_LONG).show();
        mAdapter.replaceData(devices, deviceStateResponses);
    }

    @Override
    public void showNoDevices() {
        mContainerView.setVisibility(GONE);
        mNoDevicesView.setVisibility(View.VISIBLE);
        mEmptyStateText.setText(getString(R.string.no_devices_all));
    }

    @Override
    public boolean isActive() {
        return isActive();
    }

    @Override
    public void showFailedUpdate() {

    }

    @Override
    public void showSuccessfulUpdate() {

    }
}
