package com.example.smarthomeapp.devices;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smarthomeapp.R;
import com.example.smarthomeapp.httpentities.DeviceStateResponse;
import com.example.utils.domain.Device;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DeviceViewHolder> {

    private Map<String, Device> mDevicesMap;
    private Map<String, DeviceStateResponse> mDevicesStateMap;
    private DevicesContract.Presenter mPresenter;
    private Context mContext;

    public DevicesAdapter(Context context,
                          DevicesContract.Presenter presenter,
                          Map<String, Device> devicesMap,
                          Map<String, DeviceStateResponse> devicesStateMap){
        this.mContext = context;
        this.mPresenter = presenter;
        this.mDevicesMap = devicesMap;
        this.mDevicesStateMap = devicesStateMap;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_item_2, parent, false);

        DeviceViewHolder vh = new DeviceViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {

        String deviceId = String.valueOf(position + 1);

        DeviceStateResponse deviceStateResponse = mDevicesStateMap.get(deviceId);
        Device device = mDevicesMap.get(deviceId);

//        holder.deviceIcon.setImageResource(IconUtils.getIconsMap().get(device.getId()));
        holder.deviceName.setText(device.getName());
//        holder.propertiesList.setAdapter(division.getName());

        holder.saveValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.saveDeviceValue(mPresenter.getDeviceValuesToSave());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDevicesStateMap.size();
    }

    public void replaceData(Map<String, Device> devices, Map<String, DeviceStateResponse> devicesState) {
        setDevicesStateList(devices, devicesState);
        this.notifyDataSetChanged();
    }

    private void setDevicesStateList(Map<String, Device> devices, Map<String, DeviceStateResponse> devicesState) {
        mDevicesMap.clear();
        mDevicesMap.putAll(devices);
        mDevicesStateMap.clear();
        mDevicesStateMap.putAll(devicesState);
    }

    public class DeviceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.device_icon)
        ImageView deviceIcon;
        @BindView(R.id.device_name)
        TextView deviceName;
        @BindView(R.id.property_list)
        ListView propertiesList;
        @BindView(R.id.save_value_button)
        Button saveValueButton;

        public DeviceViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
