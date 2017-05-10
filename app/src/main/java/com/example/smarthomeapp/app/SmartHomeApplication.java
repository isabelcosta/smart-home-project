package com.example.smarthomeapp.app;

import android.app.Application;

import com.example.utils.domain.HomeConfigEntity;
import com.example.utils.domain.User;

/**
 * Created by isabelcosta on 05-May-17.
 */

public class SmartHomeApplication extends Application {

    private static final SmartHomeApplication ourInstance = new SmartHomeApplication();

    private HomeConfigEntity homeConfigEntity;
    private User userEntity;

    public static SmartHomeApplication getInstance() {
        return ourInstance;
    }

    public SmartHomeApplication() {
    }

    public HomeConfigEntity getHomeConfiguration(){
        return homeConfigEntity;
    }

    public User getUserEntity(){
        return userEntity;
    }

    public void setHomeConfiguration(HomeConfigEntity homeConfig){
        homeConfigEntity = homeConfig;
    }

    public void setUserEntity(User user){
        userEntity = user;
    }

}
