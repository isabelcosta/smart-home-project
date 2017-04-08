package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class DeviceClass {

    /**
     * Attributes
     */
    private int id;
    private String name;

    /**
     * Constructor
     */
    public DeviceClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
