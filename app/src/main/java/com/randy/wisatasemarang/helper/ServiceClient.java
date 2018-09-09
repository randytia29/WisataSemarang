package com.randy.wisatasemarang.helper;

import com.randy.wisatasemarang.model.ListWisata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceClient {
    @GET("exec")
    Call<ListWisata> getWisata(@Query("sheet") String namaSheet);
}
