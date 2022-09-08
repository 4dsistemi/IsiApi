package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

public class IsiorderPrinterElementCategory {

    @SerializedName("Id")
    public int id;

    @SerializedName("CategoryId")
    public int category_id;

    @SerializedName("IsiorderPrinterRuleId")
    public int isiorder_printer_rule_id;

    public IsiorderPrinterElementCategory(int category_id, int isiorder_printer_rule_id) {
        this.category_id = category_id;
        this.isiorder_printer_rule_id = isiorder_printer_rule_id;
    }
}
