package com.randy.wisatasemarang.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final String BASE_URL = "https://script.google.com/macros/s/AKfycbxgRKVjxNgecEbJPfZpePaPdG4nYx8vBhfoWEBULTd9MX86sSUs/";
    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
