package com.isi.isiapi.classes.isiorder;

import java.util.Date;
import java.util.List;

public class IsiorderGuestOrder {

    public int id;

    public Date timestamp;

    public Integer account_id;

    public int isiorder_table_id;
    
    public int status;
    
    public int payment;

    public int number_of_people;

    public List<IsiorderGuestOrderElement> isiorder_guest_order_elements;

    public IsiorderTableElement isiorder_table_element;

}
