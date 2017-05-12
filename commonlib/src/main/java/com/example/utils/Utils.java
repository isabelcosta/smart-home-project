package com.example.utils;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class Utils {

    // Splits a String into String[] separated by commas

    public static String[] stripStringIntoV(String strList, String separator){
        String[] separatedValues = strList.split(separator);
        return separatedValues;
    }

}
