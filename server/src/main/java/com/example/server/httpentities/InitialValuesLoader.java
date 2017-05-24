package com.example.server.httpentities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.io.IOUtils;

/**
 * Created by isabelcosta on 23-May-17.
 */

public class InitialValuesLoader {

    private static String _configFilesServerPackage = "./server/src/main/java/com/example/server/configs/";
    private static String _initialValuesFilename = "initial_values.json";
    private static String _unicode = "UTF-8";

    public static ConcurrentHashMap<String, DeviceStateResponse> getDeviceInitialValues() {

        ConcurrentHashMap<String, DeviceStateResponse> devicesValues = new ConcurrentHashMap<>();

        Gson gson = new Gson();

        List<DeviceStateResponse> deviceStateResponses = null;
        BufferedReader br = null;
        TypeToken<List<DeviceStateResponse>> token = new TypeToken<List<DeviceStateResponse>>() {};

        try {
            br = new BufferedReader(new FileReader(_configFilesServerPackage + _initialValuesFilename));
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
