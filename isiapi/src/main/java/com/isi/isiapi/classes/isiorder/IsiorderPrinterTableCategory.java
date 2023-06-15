package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderPrinterTableCategory extends LastModifiedTables {

    
    public int id;

    
    public int category_id;

    
    public int isiorder_printer_rule_id;

    public IsiorderPrinterTableCategory(int category_id, int isiorder_printer_rule_id) {
        this.category_id = category_id;
        this.isiorder_printer_rule_id = isiorder_printer_rule_id;
    }
}
