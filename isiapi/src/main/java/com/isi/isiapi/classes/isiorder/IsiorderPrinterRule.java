package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

public class IsiorderPrinterRule {

    @SerializedName("Id")
    public int id;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("Description")
    public String description;

    @SerializedName("ThermalPrinterId")
    public int thermal_printer_id;

    public IsiorderPrinterRule(String description, int thermal_printer_id) {
        this.description = description;
        this.thermal_printer_id = thermal_printer_id;
    }
}
