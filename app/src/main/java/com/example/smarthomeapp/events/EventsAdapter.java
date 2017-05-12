package com.example.smarthomeapp.events;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.smarthomeapp.R;
import com.example.smarthomeapp.httpentities.EventResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> {

    private List<EventResponse> mEvents;
    private EventsContract.Presenter mPresenter;
    private Context mContext;

    public EventsAdapter(Context context,
                         List<EventResponse> events,
                         EventsContract.Presenter presenter) {
        this.mContext = context;
        this.mPresenter = presenter;
        this.mEvents = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        EventResponse event = mEvents.get(position);
        holder.mItem = event;
        holder.mEventTimestamp.setText(event.getTimeStamp());
        holder.mEventDescription.setText(
                mContext.getString(
                    R.string.user_event,
                    event.getUserId(),
                    event.getPropertyId(),
                    event.getDeviceId(),
                    event.getDeviceValue()
                ));

//        holder.mContentView.setText(event.getDeviceValue());
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public void replaceData(List<EventResponse> events) {
        setEventsList(events);
        this.notifyDataSetChanged();
    }

    private void setEventsList(List<EventResponse> events) {
        mEvents.clear();
        mEvents.addAll(events);
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        View mView;
        @BindView(R.id.event_description)
        TextView mEventDescription;
        @BindView(R.id.event_timestamp)
        TextView mEventTimestamp;
        public EventResponse mItem;

        public EventViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mEventDescription.getText() + "'" + mEventTimestamp.getText() + "'";
        }
    }
}
