package com.sonou.connecteetusonou;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitcli {
    public  static ApiService executionretrofit(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5 , TimeUnit.MINUTES)
                .readTimeout(40 , TimeUnit.SECONDS)
                .writeTimeout(25 , TimeUnit.SECONDS)
                .build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/tpconnectetusonou/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();



        ApiService service =retrofit.create(ApiService.class);
        return service;




    };
}
