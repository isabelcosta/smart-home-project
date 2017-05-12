package com.example.utils.domain;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class Property {

    private String id;
    private String name;
    private String accessMode;
    private String valueType;
    private String refValueType;

    public Property(String id,
                    String name,
                    String accessMode,
                    String valueType,
                    String refValueType) {
        this.id = id;
        this.name = name;
        this.accessMode = accessMode;
        this.valueType = valueType;
        this.refValueType = refValueType;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String Name) {
        this.name = Name;
    }

    public String getAccessMode () {
        return accessMode;
    }

    public void setAccessMode (String AccessMode) {
        this.accessMode = AccessMode;
    }

    public String getValueType () {
        return valueType;
    }

    public void setValueType (String ValueType) {
        this.valueType = ValueType;
    }

    public String getRefValueType () {
        return refValueType;
    }

    public void setRefValueType (String RefValueType) {
        this.refValueType = RefValueType;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = "+id+", name = "+ name +", accessMode = "+ accessMode +", valueType = "+ valueType +", refValueType = "+ refValueType +"]";
    }
}
