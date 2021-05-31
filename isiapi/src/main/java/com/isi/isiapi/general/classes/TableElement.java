package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class TableElement {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("table_category_id")
    public int table_category_id;

    @SerializedName("is_occupied")
    public int is_occupied;

    @SerializedName("x_position")
    public float xPosition = 0;

    @SerializedName("y_position")
    public float yPosition = 0;
}