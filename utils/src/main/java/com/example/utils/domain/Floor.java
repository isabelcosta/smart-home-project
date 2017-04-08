package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class Floor {

    /**
     * Attributes
     */
    private int id;
    private String name;
    private int heightOrder;

    /**
     * Constructor
     */
    public Floor(int id, String name, int heightOrder) {
        this.id = id;
        this.name = name;
        this.heightOrder = heightOrder;
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

    public int getHeightOrder() {
        return heightOrder;
    }

    public void setHeightOrder(int heightOrder) {
        this.heightOrder = heightOrder;
    }
}