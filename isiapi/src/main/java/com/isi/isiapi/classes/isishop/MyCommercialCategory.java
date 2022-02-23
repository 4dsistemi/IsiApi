package com.isi.isiapi.classes.isishop;

import com.google.gson.annotations.SerializedName;

public class MyCommercialCategory {

    @SerializedName("Id")
    public int id;

    @SerializedName("CommercialCategoryId")
    public int commercial_category_id;

    public MyCommercialCategory(int commercial_category_id) {
        this.commercial_category_id = commercial_category_id;
    }
}
