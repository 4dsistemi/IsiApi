package com.isi.isiapi.classes.isishop;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ExtraordinaryClosing {

    @SerializedName("Id")
    public int id;

    @SerializedName("StartDate")
    public Date start_date;

    @SerializedName("EndDate")
    public Date end_date;

    @SerializedName("Description")
    public String description;

    public ExtraordinaryClosing(Date start_date, Date end_date, String description) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
    }
}
