package com.ltdd.nhakhoaapp.model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    private final  static  String BASE_URL="http://192.168.1.10:8080/api/auth/";
    private static Retrofit retrofit = null;

    public static  ApiService getRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("HH:mm:ss")
                .setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ApiService.class);
    }
}