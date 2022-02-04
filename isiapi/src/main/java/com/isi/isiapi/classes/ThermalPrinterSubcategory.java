package com.isi.isiapi.classes;


import com.google.gson.annotations.SerializedName;

public class ThermalPrinterSubcategory {

    @SerializedName("Id")
    public int id;

    @SerializedName("PrintersId")
    public int printer_id;

    @SerializedName("CategoryId")
    public int category_id;

    public ThermalPrinterSubcategory(int printer_id, int category_id) {
        this.printer_id = printer_id;
        this.category_id = category_id;
    }
}
