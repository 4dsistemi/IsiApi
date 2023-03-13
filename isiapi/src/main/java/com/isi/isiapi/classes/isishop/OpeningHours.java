package com.isi.isiapi.classes.isishop;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OpeningHours {

    
    public int id;

    
    public Date opening1;

    
    public Date opening2;

    
    public Date closing1;

    
    public Date closing2;

    public OpeningHours(Date opening1, Date opening2, Date closing1, Date closing2) {
        this.opening1 = opening1;
        this.opening2 = opening2;
        this.closing1 = closing1;
        this.closing2 = closing2;
    }
}
