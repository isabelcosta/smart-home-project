package com.example.utils.domain;

import java.util.List;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class House {

    /**
     * Attributes
     */
    private int id;
    private String name;
    private String address;
    private String phone;

    /**
     * Elements
     */
    private List<Floor> floorList;
    private List<Division> divisionList;

    /**
     * Constructor
     */
    public House(int id, String name, String address, String phone, List<Floor> floorList, List<Division> divisionList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.floorList = floorList;
        this.divisionList = divisionList;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
    }
}
