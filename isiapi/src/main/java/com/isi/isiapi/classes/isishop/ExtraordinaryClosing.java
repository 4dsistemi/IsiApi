package com.isi.isiapi.classes.isishop;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ExtraordinaryClosing {

    @SerializedName("Id")
    public int id;

    @SerializedName("Start")
    public Date start;

    @SerializedName("End")
    public Date end;

    @SerializedName("Description")
    public String description;

    public ExtraordinaryClosing(Date start, Date end, String description) {
        this.start = start;
        this.end = end;
        this.description = description;
    }
}
