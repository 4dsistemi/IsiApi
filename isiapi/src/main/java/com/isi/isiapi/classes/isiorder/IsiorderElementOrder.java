package com.isi.isiapi.classes.isiorder;


import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiorderElementOrder extends LastModifiedTables {

    
    public int id;

    
    public int product_id;

    
    public int isiorder_order_id;

    
    public int exit_status;

    
    public int status = 0;

    
    public Long removal_account_id;

    
    public Date arrival = new Date(System.currentTimeMillis());

    
    public int payed = 0;

    
    public Long payed_account_id;

    
    public String newName = null;

    
    public float newPrice = -1;

    
    public int quantity = 1;

    
    public int deleted_quantity = 0;

    
    public Integer customerNumber = null;

    
    public int element_served = 0;

    
    public Date element_served_time = null;

    public IsiorderElementOrder(int product_id, int exit_status, int isiorder_order_id, int quantity) {
        this.product_id = product_id;
        this.exit_status = exit_status;
        this.isiorder_order_id = isiorder_order_id;
        this.quantity = quantity;
    }
}
