package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

import java.util.ArrayList;
import java.util.Date;

public class IsiorderListini extends LastModifiedTables {

    int id;
    String name;
    ArrayList<Integer> products;
    Date creation;

    public IsiorderListini(String name, ArrayList<Integer> products) {
        this.name = name;
        this.products = products;
    }
}
