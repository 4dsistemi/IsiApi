package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Department{

    @SerializedName("Id")
    public int id;

    @SerializedName("DepartmentNumber")
    public int department;

    @SerializedName("DepartmentCode")
    public String code;

    @SerializedName("ProductId")
    public Integer product_id;

    public Department(int id, int department, Integer product_id, String code) {
        this.id = id;
        this.department = department;
        this.code = code;

        if(product_id == null){
            this.product_id = 0;
        }else{
            this.product_id = product_id;
        }
    }

}
