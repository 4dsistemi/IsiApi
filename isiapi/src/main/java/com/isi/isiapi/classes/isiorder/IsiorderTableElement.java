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
    public Integer is_occupied;

    @SerializedName("XPposition")
    public float x_position = 0;

    @SerializedName("YPposition")
    public float y_position = 0;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("Guest")
    public int guest = 1;

    @SerializedName("Order")
    public IsiorderOrder order;

    public IsiorderTableElement(String name, int isiorder_table_category_id) {
        this.name = name;
        this.isiorder_table_category_id = isiorder_table_category_id;
    }
}
