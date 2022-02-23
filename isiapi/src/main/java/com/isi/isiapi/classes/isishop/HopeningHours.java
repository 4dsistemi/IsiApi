package com.isi.isiapi.classes.isishop;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class HopeningHours {

    @SerializedName("Id")
    public int id;

    @SerializedName("Opening1")
    public Date opening1;

    @SerializedName("Opening2")
    public Date opening2;

    @SerializedName("Closing1")
    public Date closing1;

    @SerializedName("Closing2")
    public Date closing2;

    public HopeningHours(Date opening1, Date opening2, Date closing1, Date closing2) {
        this.opening1 = opening1;
        this.opening2 = opening2;
        this.closing1 = closing1;
        this.closing2 = closing2;
    }
}
