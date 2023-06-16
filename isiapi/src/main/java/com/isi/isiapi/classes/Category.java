package com.isi.isiapi.classes;

import com.isi.isiapi.classes.isiorder.IsiorderNote;

import java.util.ArrayList;
import java.util.List;

public class Category extends LastModifiedTables{

    public int id;

    public String name;

    public Integer color;

    public int active = 1;

    public int guest = 1;

    public int priority;
    
    public String image;

    public List<Product> products = new ArrayList<>();

    public List<IsiorderNote> isiorder_notes = new ArrayList<>();

    public Category(int id, String name, Integer color, String image, int priority) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image = image;
        this.priority = priority;
    }
}
