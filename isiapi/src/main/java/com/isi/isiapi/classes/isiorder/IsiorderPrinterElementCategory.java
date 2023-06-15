package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderPrinterElementCategory extends LastModifiedTables {

    
    public int id;

    
    public int isiorder_table_category_id;

    
    public int isiorder_printer_rule_id;

    public IsiorderPrinterElementCategory(int isiorder_table_category_id, int isiorder_printer_rule_id) {
        this.isiorder_table_category_id = isiorder_table_category_id;
        this.isiorder_printer_rule_id = isiorder_printer_rule_id;
    }
}
