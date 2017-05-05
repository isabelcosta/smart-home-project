package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Floor {

    /**
     * Attributes
     */
    private String id;
    private String name;
    private String heightOrder;

    /**
     * Constructor
     */
    public Floor(String id, String name, String heightOrder) {
        this.id = id;
        this.name = name;
        this.heightOrder = heightOrder;
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

    public String getHeightOrder() {
        return heightOrder;
    }

    public void setHeightOrder(String heightOrder) {
        this.heightOrder = heightOrder;
    }
}