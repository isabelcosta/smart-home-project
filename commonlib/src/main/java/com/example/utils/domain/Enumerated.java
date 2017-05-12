package com.example.utils.domain;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class Enumerated {

    private String name;
    private String value;

    /**
     * Constructor
     */
    public Enumerated(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName () {
        return name;
    }

    public void setName (String Name) {
        this.name = Name;
    }

    public String getValue () {
        return value;
    }

    public void setValue (String Value) {
        this.value = Value;
    }

    @Override
    public String toString() {
        return "Enumerated [name = " + name + ", value = " + value + "]";
    }
}
