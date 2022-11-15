package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiorderOrder extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Arrival")
    public Date arrival = new Date(System.currentTimeMillis());

    @SerializedName("IsiorderTableElementId")
    public Integer isiorder_table_element_id;

    @SerializedName("AccountId")
    public int account_id;

    @SerializedName("Status")
    public int status;

    @SerializedName("Coperti")
    public int coperti;

    @SerializedName("ClosureAccountId")
    public Integer closure_account_id;

    @SerializedName("ClosureDate")
    public Date closure_date;

    @SerializedName("Type")
    public int type = 0;

    @SerializedName("Discount")
    public float discount = 0;

    @SerializedName("TotalOrder")
    public float total_order = 0;

    @SerializedName("AccountCard")
    public String account_card = null;

    @SerializedName("CopertiPayed")
    public int coperti_payed = 0;

    @SerializedName("TotalPayed")
    public float total_payed = 0;

    @SerializedName("FreeDraw")
    public byte[] free_draw = null;

    @SerializedName("OrderServed")
    public int order_served = 0;

    @SerializedName("OrderServedTime")
    public Date order_served_time = null;

    @SerializedName("IsReadyCode")
    public String is_ready_code = null;

    @SerializedName("IsiorderNote")
    public String isiorder_note;

    public IsiorderOrder(Integer isiorder_table_element_id, int account_id, int coperti) {
        this.isiorder_table_element_id = isiorder_table_element_id;
        this.account_id = account_id;
        this.coperti = coperti;
        this.status = 0;
    }


}
