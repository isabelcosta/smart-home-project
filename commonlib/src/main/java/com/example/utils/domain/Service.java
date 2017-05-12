package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Service {

    /**
     * Attributes
     */
    private String id;
    private String name;

    /**
     * Constructor
     */
    public Service(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
