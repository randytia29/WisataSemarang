package com.randy.wisatasemarang.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListWisata {

    @SerializedName("semarang")
    private List<Wisata> listWisataSemarang;

    public List<Wisata> getListWisataSemarang() {
        return listWisataSemarang;
    }
}
