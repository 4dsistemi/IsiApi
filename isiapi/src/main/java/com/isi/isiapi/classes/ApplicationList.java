package com.isi.isiapi.classes;

import com.google.gson.annotations.SerializedName;

public class ApplicationList {

    
    public int id;
    
    public String name;
    @SerializedName("package")
    public String packages;
    
    public String description;
    
    public int ut;
    
    public int canone;

}