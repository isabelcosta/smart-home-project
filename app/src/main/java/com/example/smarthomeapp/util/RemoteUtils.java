package com.example.smarthomeapp.util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isabelcosta on 12-May-17.
 */

public class RemoteUtils {

    // Change IP Address
    public static String API_BASE_URL = "http://192.168.1.36:9000/";

    public static Retrofit getRetrofitObj(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(httpClient.build()).build();

        return retrofit;
    }
}
