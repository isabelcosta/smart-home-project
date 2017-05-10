package com.example.utils.domain;

import com.example.utils.Utils;

import java.util.List;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Device {

    /**
     * Attributes
     */
    private String id;
    private String refDeviceType;
    private String name;
    private String address;
    private String refDivision;
    private String[] accessLevel;
    private String[] userBlocked;

    /**
     * Elements
     */
    private List<DeviceService> deviceServiceList;

    /**
     * Constructor
     */
    public Device(String id,
                  String refDeviceType,
                  String name,
                  String address,
                  String refDivision,
                  String accessLevel,
                  String userBlocked,
                  List<DeviceService> deviceServiceList) {

        this.id = id;
        this.refDeviceType = refDeviceType;
        this.name = name;
        this.address = address;
        this.refDivision = refDivision;
        this.accessLevel = Utils.stripStringIntoV(accessLevel);
        this.userBlocked = Utils.stripStringIntoV(userBlocked);
        this.deviceServiceList = deviceServiceList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRefDeviceType() {
        return refDeviceType;
    }

    public void setRefDeviceType(String refDeviceType) {
        this.refDeviceType = refDeviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRefDivision() {
        return refDivision;
    }

    public void setRefDivision(String refDivision) {
        this.refDivision = refDivision;
    }

    public String[] getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String[] accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String[] getUserBlocked() {
        return userBlocked;
    }

    public void setUserBlocked(String[] userBlocked) {
        this.userBlocked = userBlocked;
    }

    public List<DeviceService> getDeviceServiceList() {
        return deviceServiceList;
    }

    public void setDeviceServiceList(List<DeviceService> deviceServiceList) {
        this.deviceServiceList = deviceServiceList;
    }
}
