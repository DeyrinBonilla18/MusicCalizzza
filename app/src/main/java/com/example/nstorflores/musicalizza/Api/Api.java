package com.example.nstorflores.musicalizza.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Néstor Flores on 3/3/2018.
 */

public class Api {

    private final static String URL = "http://192.168.43.215:3000/api";

    public static String getBase() {
        return URL + "/";
    }

    public static ApiInterface instance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.getBase())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        System.out.println("MESSAGE: "+ URL);
        return retrofit.create(ApiInterface.class);
    }
}
