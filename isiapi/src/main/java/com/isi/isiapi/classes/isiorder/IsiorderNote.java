package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderNote extends LastModifiedTables {

    
    public int id;

    
    public String name;

    
    public float price;

    
    public int category_id;

    
    public int color;

    
    public int active = 1;

    public IsiorderNote(String name, float price, int category_id, int color) {
        this.name = name;
        this.price = price;
        this.category_id = category_id;
        this.color = color;
    }
}
