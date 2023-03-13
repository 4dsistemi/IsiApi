package com.isi.isiapi.classes;

import com.google.gson.annotations.SerializedName;

public class Category extends LastModifiedTables{

    
    public int id;

    
    public String name;

    
    public Integer color;

    
    public int active = 1;

    
    public int guest = 1;

    
    public String image;

    public Category(int id, String name, Integer color, String image) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image = image;
    }
}
