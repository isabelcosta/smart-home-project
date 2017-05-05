package com.example.smarthomeapp.util;

import android.util.SparseIntArray;

import com.example.smarthomeapp.R;

import java.util.HashMap;

import static com.example.smarthomeapp.util.Constants.DivisionType.ATTIC;
import static com.example.smarthomeapp.util.Constants.DivisionType.BATHROOM;
import static com.example.smarthomeapp.util.Constants.DivisionType.BEDROOM;
import static com.example.smarthomeapp.util.Constants.DivisionType.GARDEN;
import static com.example.smarthomeapp.util.Constants.DivisionType.HALL;
import static com.example.smarthomeapp.util.Constants.DivisionType.KITCHEN;
import static com.example.smarthomeapp.util.Constants.DivisionType.LIVING_ROOM;

/**
 * Created by isabelcosta on 05-May-17.
 */

public class IconUtils {


//    static HashMap<String, Integer> iconsMap = new HashMap<>();

    static {
        HashMap<String, Integer> iconsMap = new HashMap<>();
        iconsMap.put(BEDROOM, R.drawable.ic_bed);
        iconsMap.put(KITCHEN, R.drawable.ic_fridge);
        iconsMap.put(BATHROOM, R.drawable.ic_toilet);
        iconsMap.put(HALL, R.drawable.ic_bed);
        iconsMap.put(ATTIC, R.drawable.ic_bed);
        iconsMap.put(LIVING_ROOM, R.drawable.ic_sofa);
        iconsMap.put(GARDEN, R.drawable.ic_bed);
    }





}
