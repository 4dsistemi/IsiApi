package com.isi.isiapi.classes.isishop;

import com.google.gson.annotations.SerializedName;

import java.sql.Time;

public class HopeningHours {

    @SerializedName("Id")
    public int id;

    @SerializedName("Opening1")
    public Time opening1;

    @SerializedName("Opening2")
    public Time opening2;

    @SerializedName("Closing1")
    public Time closing1;

    @SerializedName("Closing2")
    public Time closing2;

    public HopeningHours(Time opening1, Time opening2, Time closing1, Time closing2) {
        this.opening1 = opening1;
        this.opening2 = opening2;
        this.closing1 = closing1;
        this.closing2 = closing2;
    }
}
