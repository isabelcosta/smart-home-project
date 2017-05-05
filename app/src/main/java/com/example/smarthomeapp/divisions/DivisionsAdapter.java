package com.example.smarthomeapp.divisions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smarthomeapp.R;
import com.example.smarthomeapp.util.IconUtils;
import com.example.utils.domain.Division;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isabelcosta on 07-Apr-17.
 */

public class DivisionsAdapter extends BaseAdapter{

    private List<Division> mDivisionsList;
    private Context mContext;

    public DivisionsAdapter(Context context, List<Division> divisionsList){
        this.mDivisionsList = divisionsList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mDivisionsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDivisionsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DivisionsViewHolder holder;

        if (convertView != null) {
            holder = (DivisionsViewHolder) convertView.getTag();

        } else {
            LayoutInflater inflater = LayoutInflater.from(mContext);

            // get layout from division_item.xml
            convertView = inflater.inflate(R.layout.division_item, parent, false);
            holder = new DivisionsViewHolder(convertView);
            convertView.setTag(holder);
        }

        Division division = mDivisionsList.get(position);

        holder.divisionText.setText(division.getName());
        holder.divisionImage.setImageResource(IconUtils.getIconsMap().get(division.getRefDivisionType()));

        return convertView;
    }

    public void replaceData(List<Division> divisions) {
        setList(divisions);
        notifyDataSetChanged();
    }

    private void setList(List<Division> divisions) {
        mDivisionsList = divisions;
    }

    public class DivisionsViewHolder {
        @BindView(R.id.division_image)
        ImageView divisionImage;
        @BindView(R.id.division_text)
        TextView divisionText;

        public DivisionsViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
