package com.isi.isiapi.classes.isicash;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiCashDepartment extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Department")
    public int department;

    @SerializedName("Code")
    public String code;

    @SerializedName("ProductId")
    public Integer product_id;

    public IsiCashDepartment(int id, int department, Integer product_id, String code) {
        this.id = id;
        this.department = department;
        this.code = code;
        this.product_id = product_id;
    }

}
