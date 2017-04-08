package com.example.utils.domain;

/**
 * Created by isabelcosta on 28/03/2017.
 */
public class DeviceService {

    /**
     * Attributes
     */
    private int refService;

    /**
     * Constructor
     */
    public DeviceService(int refService) {
        this.refService = refService;
    }

    public int getRefService() {
        return refService;
    }

    public void setRefService(int refService) {
        this.refService = refService;
    }
}
