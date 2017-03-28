package com.example.smarthomeserver.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Service {

    /**
     * Attributes
     */
    private int id;
    private String name;

    /**
     * Constructor
     */
    public Service(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
