package com.isi.isiapi.classes;

public class Category extends LastModifiedTables{

    public int id;

    public String name;

    public Integer color;

    public int active = 1;

    public int guest = 1;

    public int priority;
    
    public String image;

    public Category(int id, String name, Integer color, String image, int priority) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.image = image;
        this.priority = priority;
    }
}
