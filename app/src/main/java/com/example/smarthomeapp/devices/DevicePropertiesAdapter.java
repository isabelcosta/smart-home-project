package com.example.smarthomeapp.devices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.smarthomeapp.R;
import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.httpentities.PropertyValueResponse;
import com.example.utils.HouseConfigConstants;
import com.example.utils.domain.HomeConfigEntity;
import com.example.utils.domain.Property;

import java.util.List;

/**
 * Created by isabelcosta on 17-May-17.
 */

public class DevicePropertiesAdapter extends BaseAdapter {

    private Context mContext;
    private HomeConfigEntity mConfigEntity;
    private String mDeviceTypeId;
    private List<PropertyValueResponse> mPropertyValueResponses;

    public DevicePropertiesAdapter(
            Context context,
            String deviceTypeId,
            List<PropertyValueResponse> propertyValueResponses
    ){
        mContext = context;
        mDeviceTypeId = deviceTypeId;
        mConfigEntity = SmartHomeApplication.getInstance().getHomeConfiguration();
        mPropertyValueResponses = propertyValueResponses;

    }

    @Override
    public int getCount() {
        return mPropertyValueResponses.size();
    }

    @Override
    public PropertyValueResponse getItem(int position) {
        return mPropertyValueResponses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        PropertyValueResponse propertyValueResponse = getItem(position);
        Property property = mConfigEntity.getPropertyFromDeviceTypeByID(
                mDeviceTypeId,
                propertyValueResponse.getPropertyId()
        );

//        if (rowView == null) {
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//
//            if (property.getValueType().equals(HouseConfigConstants.ENUM)) {
//
//                rowView = inflater.inflate(R.layout.property_enum, parent, false);
//
//            } else if (property.getValueType().equals(HouseConfigConstants.SCALAR)) {
//
//                rowView = inflater.inflate(R.layout.property_scalar, parent, false);
//
//            } else {
//                // do nothing
//            }
//        }

        return null;
    }
}
