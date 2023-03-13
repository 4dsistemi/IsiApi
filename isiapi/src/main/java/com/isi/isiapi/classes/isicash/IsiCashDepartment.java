package com.isi.isiapi.classes.isicash;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiCashDepartment extends LastModifiedTables {

    
    public int id;

    
    public int department;

    
    public String code;

    
    public Integer product_id;

    public IsiCashDepartment(int id, int department, Integer product_id, String code) {
        this.id = id;
        this.department = department;
        this.code = code;
        this.product_id = product_id;
    }

}
