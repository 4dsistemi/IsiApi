package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderTableElement extends LastModifiedTables {

    
    public int id;

    
    public String name;

    
    public int isiorder_table_category_id;

    
    public Integer is_occupied;

    
    public float x_position = 0;

    
    public float y_position = 0;

    
    public int active = 1;

    
    public int guest = 1;

    
    public IsiorderOrder order;

    
    public int guest_order = 0;

    
    public boolean exit_not_set = false;

    public IsiorderTableElement(String name, int isiorder_table_category_id) {
        this.name = name;
        this.isiorder_table_category_id = isiorder_table_category_id;
    }
}
