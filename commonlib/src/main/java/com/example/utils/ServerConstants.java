package com.example.utils;

/**
 * Created by isabelcosta on 11-May-17.
 */

public interface ServerConstants {

    /*
     * RESTful API Stuff Constants
     */

    interface Handlers {
        String EVENTS = "events";
        String DIVISIONS = "divisions";
        String DEVICES = "devices";
        String OVERVIEW = "overview";
        String BAR = "/";
    }

    /*
     * JSON responses Constants
     */

    interface JsonKeys {
        String DEVICE_ID = "deviceId";
        String DEVICES_VALUES = "deviceValues";
        String VALUE = "value";
    }

    /*
     * Command Constants
     */

    interface Command {
        String GET = "GET";
        String INIT = "INIT";
        String SET = "SET";
    }

    /*
     * Command Constants
     */

    interface CRUD {
        String GET = "GET";
        String PUT = "PUT";
        String POST = "POST";
        String DELETE = "DELETE";
    }
}
