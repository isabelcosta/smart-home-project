package com.example.smarthomeserver.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class AccessLevel {

    /**
     * Attributes
     */
    private int level;
    private String name;

    /**
     * Constructor
     */
    public AccessLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
