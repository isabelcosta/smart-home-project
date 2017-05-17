package com.example.utils.domain;

import java.util.List;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class EnumValueType {

    private String name;
    private String enumId;
    private List<Enumerated> enumerated;

    /**
     * Constructor
     */
    public EnumValueType(String name, String enumId, List<Enumerated> enumerated) {
        this.name = name;
        this.enumId = enumId;
        this.enumerated = enumerated;
    }

    public String getName () {
        return name;
    }

    public void setName (String Name) {
        this.name = Name;
    }

    public String getEnumId () {
        return enumId;
    }

    public void setEnumId (String enumId) {
        this.enumId = enumId;
    }

    public List<Enumerated> getEnumerated () {
        return enumerated;
    }

    public void setEnumerated (List<Enumerated> Enumerated) {
        this.enumerated = Enumerated;
    }

    @Override
    public String toString() {
        return "EnumValueType [name = " + name + ", ID = " + enumId
                + ", enumerated = " + enumerated + "]";
    }
}
