package com.example.smarthomeapp;

import android.app.Application;

import com.example.utils.domain.HomeConfigEntity;

/**
 * Created by isabelcosta on 05-May-17.
 */

public class SmartHomeApplication extends Application {

    private static final SmartHomeApplication ourInstance = new SmartHomeApplication();

    private HomeConfigEntity homeConfigEntity;

    public static SmartHomeApplication getInstance() {
        return ourInstance;
    }

    public SmartHomeApplication() {
    }

    public HomeConfigEntity getHomeConfiguration(){
        return homeConfigEntity;
    }

    public void setHomeConfiguration(HomeConfigEntity homeConfiguration){
        homeConfigEntity = homeConfiguration;
    }

}
