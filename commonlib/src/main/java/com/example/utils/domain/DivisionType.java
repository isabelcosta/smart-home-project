package com.example.utils.domain;

/**
 * Created by isabelcosta on 05-May-17.
 */

public class DivisionType {

    /**
     * Attributes
     */
    private String id;
    private String name;

    /**
     * Constructor
     */
    public DivisionType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

}
