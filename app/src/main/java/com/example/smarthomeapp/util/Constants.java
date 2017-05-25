package com.example.smarthomeapp.util;

import com.example.smarthomeapp.R;

/**
 * Created by isabelcosta on 05-May-17.
 */

public class Constants {

    public static int XML_FILE_TO_LOAD = R.raw.basic_config_1;

    interface DivisionIconType {
        String BEDROOM = "1";
        String KITCHEN = "2";
        String BATHROOM = "3";
        String HALL = "4";
        String ATTIC = "5";
        String LIVING_ROOM = "6";
        String GARDEN = "7";
    }

    interface DeviceIconType {
        String ADJUSTABLE_LIGHT = "1";
        String TEMPERATURE_SENSOR = "2";
        String OVEN = "3";
        String HUMIDITY_RATIO = "4";
    }

    public interface Login {
        String USERNAME = "USERNAME";
        String USER_ID = "USER_ID";
        String REMEMBER_ME = "REMEMBER_ME";
    }
}
