package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderNote extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("price")
    public float price;

    @SerializedName("CategoryId")
    public int category_id;

    @SerializedName("Color")
    public int color;

    @SerializedName("Active")
    public int active = 1;

    public IsiorderNote(String name, float price, int category_id, int color) {
        this.name = name;
        this.price = price;
        this.category_id = category_id;
        this.color = color;
    }
}
