package com.isi.isiapi.classes.isishop;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ExtraordinaryClosing {

    
    public int id;

    
    public Date start_date;

    
    public Date end_date;

    
    public String description;

    public ExtraordinaryClosing(Date start_date, Date end_date, String description) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }
}
