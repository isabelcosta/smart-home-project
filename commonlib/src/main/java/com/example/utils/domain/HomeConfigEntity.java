package com.example.utils.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class HomeConfigEntity {


    private static HomeConfigEntity _instance;

    private List<Device> _deviceList;
    private List<DeviceType> _deviceTypeList;
    private List<Service> _serviceList;
    private House _house;
    private List<Floor> _floorList;
    private List<Division> _divisionList;
    private List<DivisionType> _divisionTypeList;
    private List<User> _userList;
    private List<ScalarValueType> _scalarValueList;
    private List<EnumValueType> _enumValueList;

    public static HomeConfigEntity getInstance(){
        if (_instance == null){
            return new HomeConfigEntity();
        }
        return _instance;
    }

    /**
     * Getters and Setters
     */

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

    public List<ScalarValueType> getScalarValueTypeList() {
        return _scalarValueList;
    }

    public void setFloorList(List<Floor> floorList){
        _floorList = floorList;
    }

    public List<EnumValueType> getEnumValueList() {
        return _enumValueList;
    }

    public void setEnumValueTypeList(List<EnumValueType> enumValueList) {
        _enumValueList = enumValueList;
    }

    public void setScalarValueTypeList(List<ScalarValueType> scalarValueList){
        _scalarValueList = scalarValueList;
    }

    public List<Division> getDivisionList(){
        return _divisionList;
    }

    public void setDivisionList(List<Division> divisionList){
        _divisionList = divisionList;
    }

    public void setDivisionTypeList(List<DivisionType> divisionTypeList){
        _divisionTypeList = divisionTypeList;
    }

    public List<User> getUserList() {
        return _userList;
    }

    public void setUserList(List<User> userList) {
        this._userList = userList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this._deviceList = deviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this._serviceList = serviceList;
    }

    public void setHouse(House house) {
        this._house = house;
    }

    public List<DeviceType> getDeviceTypeList() {
        return _deviceTypeList;
    }

    public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
        _deviceTypeList = deviceTypeList;
    }

    /**
     * Get Object By IDs
     */

    public User getUserByID(String userID){
        for(User user : _userList){
            if(userID.equals(user.getId())){
                return user;
            }
        }
        return null;
    }

    public Device getDeviceByID(String deviceID){
        for(Device device : _deviceList){
            if(deviceID.equals(device.getId())){
                return device;
            }
        }
        return null;
    }

    public Division getDivisionByID(String divisionID){
        for(Division division : _divisionList){
            if(divisionID.equals(division.getId())){
                return division;
            }
        }
        return null;
    }

    public List<Device> getDevicesByDivisionID(String divisionID){
        List<Device> devicesList = new ArrayList<>();
        for(Device device : _deviceList){
            if(device.getRefDivision().equals(divisionID)){
                devicesList.add(device);
            }
        }
        return devicesList;
    }
}
