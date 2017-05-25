package com.example.smarthomeapp.devices;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.smarthomeapp.R;
import com.example.smarthomeapp.app.SmartHomeApplication;
import com.example.smarthomeapp.httpentities.PropertyValueResponse;
import com.example.utils.HouseConfigConstants;
import com.example.utils.domain.EnumValueType;
import com.example.utils.domain.Enumerated;
import com.example.utils.domain.HomeConfigEntity;
import com.example.utils.domain.Property;
import com.example.utils.domain.ScalarValueType;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isabelcosta on 17-May-17.
 */

public class DevicePropertiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private HomeConfigEntity mConfigEntity;
    private String mDeviceTypeId;
    private List<PropertyValueResponse> mPropertyValueResponses;
    private Property mCurrentProperty;
    private PropertyValueResponse mCurrentPropertyValueResponse;
    private int mViewType;

    private int ENUM = 1;
    private int SCALAR = 2;

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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        RecyclerView.ViewHolder vh = null;

        if (viewType == ENUM) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.property_enum, parent, false);
            vh = new EnumPropertyViewHolder(view);

        } else if (viewType == SCALAR){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.property_scalar, parent, false);
            vh = new ScalarPropertyViewHolder(view);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(mViewType == ENUM) {
            EnumPropertyViewHolder enumHolder = (EnumPropertyViewHolder) holder;

            // Set title
            enumHolder.enumTitle.setText(mCurrentProperty.getName());
            // Set list of options
            EnumValueType enumValueType = mConfigEntity.getEnumByID(mCurrentProperty.getRefValueType());
            enumHolder.enumSelectionList.setLayoutManager(new LinearLayoutManager(mContext));
            enumHolder.enumSelectionList.setAdapter(new SelectableOptionsListViewAdapter(enumValueType.getEnumerated()));

        } else if(mViewType == SCALAR) {
            ScalarPropertyViewHolder scalarHolder = (ScalarPropertyViewHolder) holder;

            // Set title
            scalarHolder.scalarTitle.setText(mCurrentProperty.getName());
            // Set seek bar
            ScalarValueType scalarValueType = mConfigEntity.getScalarByID(mCurrentProperty.getRefValueType());
            scalarHolder.scalarMin.setText(scalarValueType.getMinValue());
            scalarHolder.scalarMax.setText(scalarValueType.getMaxValue());
//            scalarHolder.scalarSeekBar.setMax(Integer.getInteger(scalarValueType.getMaxValue()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        mCurrentPropertyValueResponse = mPropertyValueResponses.get(position);
        mCurrentProperty = mConfigEntity.getPropertyFromDeviceTypeByID(
                mDeviceTypeId,
                mCurrentPropertyValueResponse.getPropertyId()
        );

        int viewType;
        switch (mCurrentProperty.getValueType()){
            case HouseConfigConstants.ENUM:
                viewType = ENUM;
                break;
            case HouseConfigConstants.SCALAR:
                viewType = SCALAR;
                break;
            default:
                viewType = 0;
        }
        mViewType = viewType;
        return viewType;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return mPropertyValueResponses.size();
    }

    public class EnumPropertyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.enum_title)
        TextView enumTitle;
        @BindView(R.id.enum_selection_view)
        RecyclerView enumSelectionList;

        public EnumPropertyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ScalarPropertyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.scalar_title)
        TextView scalarTitle;
        @BindView(R.id.scalar_max)
        TextView scalarMax;
        @BindView(R.id.scalar_min)
        TextView scalarMin;
        @BindView(R.id.scalar_seek_bar)
        SeekBar scalarSeekBar;

        public ScalarPropertyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Enumerated Options Adapter
     */
    public class SelectableOptionsListViewAdapter extends RecyclerView.Adapter<EnumeratedViewHolder> {

        private List<Enumerated> _enumeratedOptionsList;

        public SelectableOptionsListViewAdapter(List<Enumerated> enumeratedOptions){
            _enumeratedOptionsList = enumeratedOptions;
        }

        @Override
        public EnumeratedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.enumerated_item, parent, false);
            EnumeratedViewHolder vh = new EnumeratedViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(EnumeratedViewHolder holder, int position) {
            Enumerated enumerated = _enumeratedOptionsList.get(position);
            holder.enumeratedText.setText(enumerated.getName());
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getItemCount() {
            return _enumeratedOptionsList.size();
        }
    }

    public class EnumeratedViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.enumerated_rounded_checkbox)
        RadioButton enumeratedText;

        public EnumeratedViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
