package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class DeviceService {

    /**
     * Attributes
     */
    private String refService;

    /**
     * Constructor
     */
    public DeviceService(String refService) {
        this.refService = refService;
    }

    public String getRefService() {
        return refService;
    }

    public void setRefService(String refService) {
        this.refService = refService;
    }
}
