package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DevicesAuthorization {

    
    public int id;

    
    public String description;

    
    public Date creation = new Date();

    
    public String mac_address;

    
    public int device_active = 1;

    public DevicesAuthorization(String description, String mac_address) {
        this.description = description;
        this.mac_address = mac_address;
    }
}
