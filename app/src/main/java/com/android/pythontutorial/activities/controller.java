package com.android.pythontutorial.activities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class controller {
    private static final String url = "https://pythontutorialapp.000webhostapp.com/pythontutorialapp/";
    private static controller clientObj;
    private static Retrofit retrofit;

    controller(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized controller getInstance(){
        if(clientObj == null){
            clientObj = new controller();
        }
        return clientObj;
    }

    apiset getapi(){
        return retrofit.create(apiset.class);
    }
}
