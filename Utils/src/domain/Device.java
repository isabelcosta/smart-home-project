package domain;

import java.util.List;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Device {

    /**
     * Attributes
     */
    private int id;
    private int refDeviceType;
    private String name;
    private int address;
    private int refDivision;
    private List<Integer> accessLevel;
    private List<Integer> userBlocked;

    /**
     * Elements
     */
    private List<DeviceService> deviceServiceList;

    /**
     * Constructor
     */
    public Device(int id,
                  int refDeviceType,
                  String name,
                  int address,
                  int refDivision,
                  List<Integer> accessLevel,
                  List<Integer> userBlocked,
                  List<DeviceService> deviceServiceList) {

        this.id = id;
        this.refDeviceType = refDeviceType;
        this.name = name;
        this.address = address;
        this.refDivision = refDivision;
        this.accessLevel = accessLevel;
        this.userBlocked = userBlocked;
        this.deviceServiceList = deviceServiceList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRefDeviceType() {
        return refDeviceType;
    }

    public void setRefDeviceType(int refDeviceType) {
        this.refDeviceType = refDeviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getRefDivision() {
        return refDivision;
    }

    public void setRefDivision(int refDivision) {
        this.refDivision = refDivision;
    }

    public List<Integer> getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(List<Integer> accessLevel) {
        this.accessLevel = accessLevel;
    }

    public List<Integer> getUserBlocked() {
        return userBlocked;
    }

    public void setUserBlocked(List<Integer> userBlocked) {
        this.userBlocked = userBlocked;
    }

    public List<DeviceService> getDeviceServiceList() {
        return deviceServiceList;
    }

    public void setDeviceServiceList(List<DeviceService> deviceServiceList) {
        this.deviceServiceList = deviceServiceList;
    }
}
