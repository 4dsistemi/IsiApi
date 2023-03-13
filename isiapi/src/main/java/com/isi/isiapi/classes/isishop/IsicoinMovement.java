package com.isi.isiapi.classes.isishop;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsicoinMovement {

    
    public int id;

    
    public Date creation = new Date();

    
    public int amount;

    
    public String description;

    
    public int type;

    public IsicoinMovement(int amount, String description, int type) {
        this.amount = amount;
        this.description = description;
        this.type = type;
    }
}
