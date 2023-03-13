package com.isi.isiapi.classes.isimaga;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class Forniture extends LastModifiedTables {

    
    public int id;

    
    public String name;

    
    public String email;

    
    public String phone;

    
    public boolean active = true;

    public Forniture(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
