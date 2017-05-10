package com.example.smarthomeapp;

import com.example.utils.domain.HomeConfigEntity;

/**
 * Created by isabelcosta on 10-May-17.
 */

public interface HouseConfigLoadPresenter extends BasePresenter {

    void loadHouseConfiguration(HomeConfigEntity homeConfigEntity);
    void cancelHouseConfigLoadTask();
}
