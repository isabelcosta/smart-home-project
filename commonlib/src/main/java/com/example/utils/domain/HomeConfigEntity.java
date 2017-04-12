package com.example.utils.domain;

import java.util.List;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class HomeConfigEntity {


    private static HomeConfigEntity _instance;

    private List<Device> _deviceList;
    private List<Service> _serviceList;
    private House _house;

    public static HomeConfigEntity getInstance(){
        if (_instance == null){
            return new HomeConfigEntity();
        }
        return _instance;
    }

    public List<Device> getDeviceList() {
        return _deviceList;
    }

    public List<Service> getServiceList() {
        return _serviceList;
    }

    private House getHouse() {
        return _house;
    }

    public List<Floor> getFloorList() {
        return getHouse().getFloorList();
    }
}
