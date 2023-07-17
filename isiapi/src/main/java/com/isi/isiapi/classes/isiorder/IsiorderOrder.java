package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.Account;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiorderOrder extends LastModifiedTables {

    
    public int id;

    
    public Date arrival = new Date(System.currentTimeMillis());

    
    public Integer isiorder_table_element_id;

    
    public int account_id;

    
    public int status;

    
    public int coperti;

    
    public Integer closure_account_id;

    
    public Date closure_date;

    
    public int type = 0;

    
    public float discount = 0;

    
    public float total_order = 0;

    
    public String account_card = null;

    
    public int coperti_payed = 0;

    
    public float total_payed = 0;

    
    public byte[] free_draw = null;

    
    public int order_served = 0;

    
    public Date order_served_time = null;

    
    public String is_ready_code = null;

    
    public String isiorder_note;

    public int customer_type = 0;

    public Account isiorder_account;

    public IsiorderOrder(Integer isiorder_table_element_id, int account_id, int coperti) {
        this.isiorder_table_element_id = isiorder_table_element_id;
        this.account_id = account_id;
        this.coperti = coperti;
        this.status = 0;
    }


}
