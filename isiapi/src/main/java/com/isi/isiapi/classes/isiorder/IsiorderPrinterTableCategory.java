package com.isi.isiapi.classes.isiorder;
import com.google.gson.annotations.SerializedName;

public class IsiorderPrinterTableCategory {

    @SerializedName("Id")
    public int id;

    @SerializedName("IsiorderTableCategoryId")
    public int isiorder_table_category_id;

    @SerializedName("IsiorderPrinterRuleId")
    public int isiorder_printer_rule_id;

    public IsiorderPrinterTableCategory(int isiorder_table_category_id, int isiorder_printer_rule_id) {
        this.isiorder_table_category_id = isiorder_table_category_id;
        this.isiorder_printer_rule_id = isiorder_printer_rule_id;
    }
}
