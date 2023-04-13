package com.isi.isiapi.classes.isimaga;

import java.util.Date;

public class OrderToForniture {

    
    public int id;

    
    public Date arrival = new Date();

    
    public int status = 0;

    
    public int forniture_id;

    public OrderToForniture(int forniture_id) {
        this.forniture_id = forniture_id;
    }
}
