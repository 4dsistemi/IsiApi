package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderTableElement extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("IsiorderTableCategoryId")
    public int isiorder_table_category_id;

    @SerializedName("IsOccupied")
    public int is_occupied;

    @SerializedName("XPposition")
    public float x_position = 0;

    @SerializedName("YPposition")
    public float y_position = 0;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("Guest")
    public int guest = 1;

    public IsiorderTableElement(String name, int isiorder_table_category_id, int is_occupied) {
        this.name = name;
        this.isiorder_table_category_id = isiorder_table_category_id;
        this.is_occupied = is_occupied;
    }
}
