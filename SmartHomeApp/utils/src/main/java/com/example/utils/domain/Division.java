package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Division {

    /**
     * Attributes
     */
    private int id;
    private String name;
    private int refFloor;
    private int accessLevel;

    /**
     * Constructor
     */
    public Division(int id, String name, int refFloor, int accessLevel) {
        this.id = id;
        this.name = name;
        this.refFloor = refFloor;
        this.accessLevel = accessLevel;
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

    public int getRefFloor() {
        return refFloor;
    }

    public void setRefFloor(int refFloor) {
        this.refFloor = refFloor;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
