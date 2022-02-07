package com.isi.isiapi.classes;

import com.google.gson.annotations.SerializedName;

public class Category extends LastModifiedTables{

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Color")
    public Integer color;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("Guest")
    public int guest = 1;

    @SerializedName("Image")
    public String image;

    public Category(int id, String name, Integer color, String image) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image = image;
    }
}
