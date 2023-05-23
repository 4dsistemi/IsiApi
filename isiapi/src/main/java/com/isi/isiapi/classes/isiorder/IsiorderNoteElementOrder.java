package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderNoteElementOrder extends LastModifiedTables {

    
    public int id;

    
    public String description;

    
    public Integer isiorder_note_id;

    
    public int isiorder_element_order_id;

    public IsiorderNoteElementOrder(Integer isiorder_note_id, int isiorder_element_order_id) {
        this.isiorder_note_id = isiorder_note_id;
        this.isiorder_element_order_id = isiorder_element_order_id;
    }

}
