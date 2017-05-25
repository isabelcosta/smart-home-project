package com.example.smarthomeapp.devices;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smarthomeapp.R;
import com.example.smarthomeapp.allcontrol.AllControlContract;
import com.example.smarthomeapp.allcontrol.AllControlFragment;
import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.smarthomeapp.util.IconUtils;
import com.example.utils.domain.Device;
import com.example.utils.domain.Division;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder> {

    private List<Device> mDevicesList;
    private List<DeviceStateResponse> mDevicesStateList;
    private DevicesContract.Presenter mDevicesPresenter;
    private AllControlContract.Presenter mAllControlPresenter;
    private Context mContext;
    private boolean _isByDivisions;

    public DevicesAdapter(Context context,
                          DevicesContract.Presenter presenter,
                          List<Device> devicesMap,
                          List<DeviceStateResponse> devicesStateMap){
        this.mContext = context;
        this.mDevicesPresenter = presenter;
        this.mDevicesList = devicesMap;
        this.mDevicesStateList = devicesStateMap;
        this._isByDivisions = true;
    }

    public DevicesAdapter(Context context,
                          AllControlContract.Presenter presenter,
                          List<Device> devicesMap,
                          List<DeviceStateResponse> devicesStateMap){
        this.mContext = context;
        this.mAllControlPresenter = presenter;
        this.mDevicesList = devicesMap;
        this.mDevicesStateList = devicesStateMap;
        this._isByDivisions = false;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_item, parent, false);

        DeviceViewHolder vh = new DeviceViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {

        DeviceStateResponse deviceStateResponse = mDevicesStateList.get(position);
        Device device = mDevicesList.get(position);

        holder.deviceIcon.setImageResource(IconUtils.getDevicesIconsMap().get(device.getRefDeviceType()));
        holder.deviceName.setText(device.getName());

        if(!_isByDivisions){
            holder.deviceDivision.setVisibility(View.VISIBLE);
            Division division = SmartHomeApplication
                    .getInstance()
                    .getHomeConfiguration()
                    .getDivisionByID(device.getRefDivision());
            holder.deviceDivision.setText(division.getName());
        }
        holder.deviceName.setText(device.getName());

        holder.propertiesList.setLayoutManager(new LinearLayoutManager(mContext));
        holder.propertiesList.setAdapter(
                new DevicePropertiesAdapter(
                        mContext,
                        device.getRefDeviceType(),
                        deviceStateResponse.getValues()
                )
        );

        holder.saveValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDevicesPresenter.saveDeviceValue(mDevicesPresenter.getDeviceValuesToSave());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDevicesStateList.size();
    }

    public void replaceData(List<Device> devices, List<DeviceStateResponse> devicesState) {
        setDevicesStateList(devices, devicesState);
        this.notifyDataSetChanged();
    }

    private void setDevicesStateList(List<Device> devices, List<DeviceStateResponse> devicesState) {
        mDevicesList.clear();
        mDevicesList.addAll(devices);
        mDevicesStateList.clear();
        mDevicesStateList.addAll(devicesState);
    }

    public class DeviceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.device_icon)
        ImageView deviceIcon;
        @BindView(R.id.device_name)
        TextView deviceName;
        @BindView(R.id.device_division)
        TextView deviceDivision;
        @BindView(R.id.property_list)
        RecyclerView propertiesList;
        @BindView(R.id.save_value_button)
        Button saveValueButton;

        public DeviceViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
