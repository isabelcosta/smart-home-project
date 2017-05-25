package com.example.smarthomeapp.util;

import com.example.smarthomeapp.R;

import java.util.HashMap;

import static com.example.smarthomeapp.util.Constants.DivisionIconType.*;
import static com.example.smarthomeapp.util.Constants.DeviceIconType.*;

/**
 * Created by isabelcosta on 05-May-17.
 */

public class IconUtils {


    private static HashMap<String, Integer> divisionIconsMap = new HashMap<>();
    private static HashMap<String, Integer> devicesIconsMap = new HashMap<>();

    static {
        divisionIconsMap.put(BEDROOM, R.drawable.ic_bed);
        divisionIconsMap.put(KITCHEN, R.drawable.ic_fridge);
        divisionIconsMap.put(BATHROOM, R.drawable.ic_toilet);
        divisionIconsMap.put(HALL, R.drawable.ic_bed);
        divisionIconsMap.put(ATTIC, R.drawable.ic_bed);
        divisionIconsMap.put(LIVING_ROOM, R.drawable.ic_sofa);
        divisionIconsMap.put(GARDEN, R.drawable.ic_bed);

        devicesIconsMap.put(ADJUSTABLE_LIGHT, R.drawable.ic_filament);
        devicesIconsMap.put(TEMPERATURE_SENSOR, R.drawable.ic_temperature);
        devicesIconsMap.put(OVEN, R.drawable.ic_oven);
        devicesIconsMap.put(HUMIDITY_RATIO, R.drawable.ic_apps);
    }


    public static HashMap<String, Integer> getDivisionsIconsMap(){
        return divisionIconsMap;
    }

    public static HashMap<String, Integer> getDevicesIconsMap(){
        return devicesIconsMap;
    }


}
