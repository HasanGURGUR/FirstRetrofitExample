package com.hasangurgur.firstretrofitexample;

import java.util.PropertyResourceBundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://animechan.vercel.app/api/";
    private static Retrofit retrofit = null;


    public static AnimeApi getRetrofitClient(){


        if (retrofit==null){


            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(AnimeApi.class);
    }
}
