package com.randy.wisatasemarang.helper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ServiceClient {
    @GET("exec")
    Call<ListWisata> getWisata(@Query("sheet") String namaSheet);
}
