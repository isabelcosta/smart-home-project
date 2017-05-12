package com.example.smarthomeapp.events;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smarthomeapp.BaseFragment;
import com.example.smarthomeapp.R;
import com.example.smarthomeapp.httpentities.EventResponse;
import com.example.smarthomeapp.util.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This fragmente shows the most recent events in the smart home
 */
public class EventsFragment extends BaseFragment implements EventsContract.View {

    private EventsContract.Presenter mPresenter;
    private EventsAdapter mAdapter;

    @BindView(R.id.event_list)
    RecyclerView mEventsRecyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EventsFragment() {
    }

    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the presenter
        mPresenter = new EventsPresenter(this);

        mAdapter = new EventsAdapter(
                getContext(),
                new ArrayList<EventResponse>(0),
                mPresenter
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, view);

        // Set the adapter
        mEventsRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(EventsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showEvents(List<EventResponse> events) {
        mAdapter.replaceData(events);
    }

    @Override
    public void showEventsUi(List<EventResponse> events) {

    }

    @Override
    public void showNoEvents() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
