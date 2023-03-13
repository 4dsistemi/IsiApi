package com.isi.isiapi.classes;

import com.google.gson.annotations.SerializedName;

public class GYBToken extends LastModifiedTables{

    
    public int id;

    
    public String refresh_token;

    public GYBToken(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
