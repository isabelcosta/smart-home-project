package com.example.smarthomeapp.presentation.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smarthomeapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isabelcosta on 07-Apr-17.
 */

public class DivisionsAdapter extends BaseAdapter{

    private List<String> _divisionsList;
    private Context _context;

    public DivisionsAdapter(Context context, List<String> divisionsList){
        this._divisionsList = divisionsList;
        this._context = context;
    }

    @Override
    public int getCount() {
        return _divisionsList.size();
    }

    @Override
    public Object getItem(int position) {
        return _divisionsList.get(position);
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
            LayoutInflater inflater = LayoutInflater.from(_context);

            // get layout from division_item.xml
            convertView = inflater.inflate(R.layout.division_item, parent, false);
            holder = new DivisionsViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.divisionText.setText(_divisionsList.get(position));
        // TODO: 07-Apr-17 create hashMap with icons mapped to divisions
        holder.divisionImage.setImageResource(R.drawable.ic_bed);

        return convertView;
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
