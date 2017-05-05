package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Division {

    /**
     * Attributes
     */
    private String id;
    private String name;
    private String refFloor;
    private String accessLevel;
    private String refDivisionType;

    /**
     * Constructor
     */
    public Division(String id, String name, String refFloor, String accessLevel, String refDivisionType) {
        this.id = id;
        this.name = name;
        this.refFloor = refFloor;
        this.accessLevel = accessLevel;
        this.refDivisionType = refDivisionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRefFloor() {
        return refFloor;
    }

    public void setRefFloor(String refFloor) {
        this.refFloor = refFloor;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getRefDivisionType() {
        return refDivisionType;
    }

    public void setRefDivisionType(String refDivisionType) {
        this.refDivisionType = refDivisionType;
    }

}
