package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DevicesAuthorization {

    @SerializedName("Id")
    public int id;

    @SerializedName("Description")
    public String description;

    @SerializedName("Creation")
    public Date creation = new Date();

    @SerializedName("MacAddress")
    public String mac_address;

    @SerializedName("DeviceActive")
    public int device_active = 1;

    public DevicesAuthorization(String description, String mac_address) {
        this.description = description;
        this.mac_address = mac_address;
    }
}
