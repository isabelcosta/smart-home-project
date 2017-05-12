package com.example.smarthomeapp.events;

import com.example.smarthomeapp.BasePresenter;
import com.example.smarthomeapp.BaseView;
import com.example.smarthomeapp.httpentities.EventResponse;

import java.util.List;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class EventsContract {

    interface View extends BaseView<EventsContract.Presenter> {

        void setLoadingIndicator(boolean active);

        void showEvents(List<EventResponse> events);

        void showEventsUi(List<EventResponse> events);

        void showNoEvents();

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadEvents();

        List<EventResponse> getDummyEvents();
    }


}
