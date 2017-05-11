package com.example.utils.domain;

import java.util.List;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class DeviceType {

    private String id;
    private String name;
    private String description;
    private String refDeviceClass;
    private List<Property> propertyList;

    public DeviceType(String id,
                      String name,
                      String description,
                      String refDeviceClass,
                      List<Property> propertyList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.refDeviceClass = refDeviceClass;
        this.propertyList = propertyList;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String Name) {
        this.name = Name;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String Description) {
        this.description = Description;
    }

    public String getRefDeviceClass () {
        return refDeviceClass;
    }

    public void setRefDeviceClass (String RefDeviceClass) {
        this.refDeviceClass = RefDeviceClass;
    }

    public List<Property> getPropertyList () {
        return propertyList;
    }

    public void setPropertyList (List<Property> PropertyList) {
        this.propertyList = PropertyList;
    }

    @Override
    public String toString() {
        return "DeviceType [id = " + id + ", name = " + name + ", description = " + description
                + ", refDeviceClass = " + refDeviceClass + ", propertyList = " + propertyList + "]";
    }
}
