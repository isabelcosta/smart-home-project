package com.example.server.httpentities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by isabelcosta on 23-May-17.
 */

public class InitialValuesLoader {

    private static String _configFilesServerPackage = "./server/src/main/java/com/example/server/configs/";
    private static String _unicode = "UTF-8";

    public static ConcurrentHashMap<String, DeviceStateResponse> getDeviceInitialValues(String initialValuesFilename) {

        ConcurrentHashMap<String, DeviceStateResponse> devicesValues = new ConcurrentHashMap<>();

        Gson gson = new Gson();

        List<DeviceStateResponse> deviceStateResponses = null;
        BufferedReader br = null;
        TypeToken<List<DeviceStateResponse>> token = new TypeToken<List<DeviceStateResponse>>() {};

        try {
            br = new BufferedReader(new FileReader(_configFilesServerPackage + initialValuesFilename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (br != null) {
            deviceStateResponses = gson.fromJson(br, token.getType());

            for (DeviceStateResponse deviceState : deviceStateResponses) {
                devicesValues.put(deviceState.getDeviceId(), deviceState);
            }
            return devicesValues;
        }

        return null;
    }
}
