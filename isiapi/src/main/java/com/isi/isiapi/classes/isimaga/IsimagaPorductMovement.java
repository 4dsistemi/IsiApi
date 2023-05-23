package com.isi.isiapi.classes.isimaga;

import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;

public class IsimagaPorductMovement extends LastModifiedTables {

    
    public int id;

    
    public Date arrival = new Date();

    
    public int product_forniture_id;

    
    public float quantity;

    
    public boolean is_plus;

    
    public String fattura_nr;

    public IsimagaPorductMovement(int product_forniture_id, float quantity, boolean is_plus, String fattura_nr) {
        this.product_forniture_id = product_forniture_id;
        this.quantity = quantity;
        this.is_plus = is_plus;
        this.fattura_nr = fattura_nr;
    }
}
