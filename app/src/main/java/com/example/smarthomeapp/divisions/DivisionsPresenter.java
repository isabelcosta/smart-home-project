package com.example.smarthomeapp.divisions;

import android.support.annotation.NonNull;

import com.example.smarthomeapp.app.SmartHomeApplication;

/**
 * Created by isabelcosta on 06-May-17.
 */

public class DivisionsPresenter implements DivisionsContract.Presenter {

    private final DivisionsContract.View mDivisionsView;

    public DivisionsPresenter(@NonNull DivisionsContract.View divisionsView) {
//        mTasksRepository = divisionsRepository;
        mDivisionsView = divisionsView;

        mDivisionsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadDivisions();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadDivisions() {

        mDivisionsView.showDivisions(
                SmartHomeApplication
                        .getInstance()
                        .getHomeConfiguration()
                        .getDivisionList()
        );
    }
}
