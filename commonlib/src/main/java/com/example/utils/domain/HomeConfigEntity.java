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
    private List<Floor> _floorList;
    private List<Division> _divisionList;
    private List<DivisionType> _divisionTypeList;
    private List<User> _userList;

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
        return _floorList;
    }

    public void setFloorList(List<Floor> floorList){
        _floorList = floorList;
    }

    public List<Division> getDivisionList(){
        return _divisionList;
    }

    public void setDivisionList(List<Division> divisionList){
        _divisionList = divisionList;
    }

    public void setDivisionTypeList(List<DivisionType> _divisionTypeList){
        _divisionTypeList = _divisionTypeList;
    }

    public List<User> getUserList() {
        return _userList;
    }

    public void setUserList(List<User> userList) {
        this._userList = userList;
    }

}
