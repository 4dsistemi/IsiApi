package com.isi.isiapi.classes;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Commercial extends LastModifiedTables{

    
    @NonNull
    public String local_id = "";

    
    public Date creation;

    
    public Date first_activation;

    
    public Date last_activation;

    
    public int points;

    
    public int promo_24_week;

    
    public double latitude;

    
    public double longitude;

    
    public String logo;

    
    public int is_on_cityzon;

    
    public String name;

    
    public String society;

    
    public String address;

    
    public String phone;

    
    public String iva;

    
    public String website;

    
    public String cap;

    
    public String email;

    
    public String description;

}
