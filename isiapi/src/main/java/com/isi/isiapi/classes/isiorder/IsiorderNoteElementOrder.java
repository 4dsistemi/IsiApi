package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderNoteElementOrder extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Description")
    public String description;

    @SerializedName("IsiorderNoteId")
    public Integer isiorder_note_id;

    @SerializedName("IsiorderElementOrderId")
    public int isiorder_element_order_id;

    public IsiorderNoteElementOrder(Integer isiorder_note_id, int isiorder_element_order_id) {
        this.isiorder_note_id = isiorder_note_id;
        this.isiorder_element_order_id = isiorder_element_order_id;
    }

}
