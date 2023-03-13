package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

public class IsiorderPrinterRule {

    
    public int id;

    
    public int active = 1;

    
    public String description;

    
    public int thermal_printer_id;

    public IsiorderPrinterRule(String description, int thermal_printer_id) {
        this.description = description;
        this.thermal_printer_id = thermal_printer_id;
    }
}
