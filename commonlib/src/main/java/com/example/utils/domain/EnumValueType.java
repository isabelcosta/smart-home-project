package com.example.utils.domain;

import java.util.List;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class EnumValueType {

    private String name;
    private String ID;
    private List<Enumerated> enumerated;

    /**
     * Constructor
     */
    public EnumValueType(String name, String ID, List<Enumerated> enumerated) {
        this.name = name;
        this.ID = ID;
        this.enumerated = enumerated;
    }

    public String getName () {
        return name;
    }

    public void setName (String Name) {
        this.name = Name;
    }

    public String getID () {
        return ID;
    }

    public void setID (String ID) {
        this.ID = ID;
    }

    public List<Enumerated> getEnumerated () {
        return enumerated;
    }

    public void setEnumerated (List<Enumerated> Enumerated) {
        this.enumerated = Enumerated;
    }

    @Override
    public String toString() {
        return "EnumValueType [name = " + name + ", ID = " + ID
                + ", enumerated = " + enumerated + "]";
    }
}
