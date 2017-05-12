package com.example.smarthomeapp.events;

import android.provider.CalendarContract;
import android.support.annotation.NonNull;

import com.example.smarthomeapp.httpentities.EventResponse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class EventsPresenter implements EventsContract.Presenter {

    private EventsContract.View mEventsView;

    public EventsPresenter(@NonNull EventsContract.View eventsView){
        mEventsView = eventsView;
        mEventsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadEvents();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadEvents() {
        mEventsView.setLoadingIndicator(false);
        mEventsView.showEvents(getDummyEvents());
    }

    public List<EventResponse> getDummyEvents(){
        List<EventResponse> events = new ArrayList<>();

        int maxEvents = 6;
        Random rn = new Random();

        for(int i = 0; i < maxEvents; i++) {
            EventResponse e = new EventResponse();
            e.setDeviceId(String.valueOf(rn.nextInt(10)));
            e.setDivisionId(String.valueOf(rn.nextInt(10)));
            e.setDivisionId(String.valueOf(rn.nextInt(10)));
            e.setTimeStamp(Calendar.getInstance().getTime().toString());
            e.setUserId(String.valueOf(rn.nextInt(10)));
            e.setPropertyId(String.valueOf(rn.nextInt(10)));
            events.add(e);
        }
        return events;
    }
}
