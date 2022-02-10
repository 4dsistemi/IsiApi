package com.isi.isiapi.classes.isiorder;


import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiorderElementOrder extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("ProductId")
    public int product_id;

    @SerializedName("IsiorderOrderId")
    public int isiorder_order_id;

    @SerializedName("ExitStatus")
    public int exit_status;

    @SerializedName("Status")
    public int status = 0;

    @SerializedName("RemovalAccountId")
    public Long removal_account_id;

    @SerializedName("Arrival")
    public Date arrival = new Date(System.currentTimeMillis());

    @SerializedName("Payed")
    public int payed = 0;

    @SerializedName("PayedAccountId")
    public Long payed_account_id;

    @SerializedName("NewName")
    public String newName = null;

    @SerializedName("NewPrice")
    public float newPrice = -1;

    @SerializedName("Quantity")
    public int quantity = 1;

    @SerializedName("DeletedQuantity")
    public int deleted_quantity = 0;

    public IsiorderElementOrder(int product_id, int exit_status, int isiorder_order_id, int quantity) {
        this.product_id = product_id;
        this.exit_status = exit_status;
        this.isiorder_order_id = isiorder_order_id;
        this.quantity = quantity;
    }
}
