package com.intkhabahmed.githubquery.network;

import android.content.Context;

import com.intkhabahmed.githubquery.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    private static Retrofit client;

    public static Retrofit getClient() {
        if (client == null) {
            client = new Retrofit.Builder()
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .build();
        }
        return client;
    }
}
