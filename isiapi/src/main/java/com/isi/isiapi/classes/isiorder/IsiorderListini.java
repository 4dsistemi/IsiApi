package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

import java.util.ArrayList;
import java.util.Date;

public class IsiorderListini extends LastModifiedTables {

    public int id;
    public String name;
    public ArrayList<Integer> products;
    public Date creation;
    public int active = 1;

    public IsiorderListini(String name, ArrayList<Integer> products) {
        this.name = name;
        this.products = products;
    }
}
