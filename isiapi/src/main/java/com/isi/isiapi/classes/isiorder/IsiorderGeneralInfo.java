package com.isi.isiapi.classes.isiorder;


import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderGeneralInfo extends LastModifiedTables {

    
    public int id;

    public long order_guest = 0;

    public long reservation_service = 0;

    public long chat_service = 0;

    public long isidel_service = 0;

    public int max_number_of_people = 0;

    public float coperto = 0;

    public boolean free_draw = false;

    public int print_daily_number = 0;

}
