package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsiorderGuestOrder {

    @SerializedName("Id")
    public int id;

    @SerializedName("Timestamp")
    public Date timestamp;

    @SerializedName("AccountId")
    public Integer account_id;

    @SerializedName("IsiorderTableId")
    public int isiorder_table_id;

    @SerializedName("Status")
    public int status;

    @SerializedName("Payment")
    public int payment;

}
