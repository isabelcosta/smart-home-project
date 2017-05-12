package com.example.server.httpentities;

/**
 * Created by isabelcosta on 11-May-17.
 */

public class PropertyValueResponse {

    public String propertyId;
    public String propertyValue;

    public PropertyValueResponse(String propertyId, String propertyValue) {
        this.propertyId = propertyId;
        this.propertyValue = propertyValue;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
