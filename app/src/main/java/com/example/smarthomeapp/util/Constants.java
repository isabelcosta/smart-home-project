package com.example.smarthomeapp.util;

import com.example.smarthomeapp.R;

/**
 * Created by isabelcosta on 05-May-17.
 */

public class Constants {

    public static int XML_FILE_TO_LOAD = R.raw.basic_config_1;

    interface DivisionType {
        String BEDROOM = "1";
        String KITCHEN = "2";
        String BATHROOM = "3";
        String HALL = "4";
        String ATTIC = "5";
        String LIVING_ROOM = "6";
        String GARDEN = "7";
    }

    public interface Login {
        String USERNAME = "USERNAME";
        String USER_ID = "USER_ID";
        String REMEMBER_ME = "REMEMBER_ME";
    }
}
