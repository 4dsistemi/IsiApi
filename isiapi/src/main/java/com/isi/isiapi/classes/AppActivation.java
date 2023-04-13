package com.isi.isiapi.classes;


import java.util.Date;

public class AppActivation extends LastModifiedTables{

    
    public int id;

    
    public int application_id;

    
    public Integer priority;

    
    public Date activation_time;

    
    public int position_in_menu;

    
    public int active;

    public AppActivation(int application_id, Integer priority, Date activation_time, int position_in_menu, int active) {
        this.application_id = application_id;
        this.priority = priority;
        this.activation_time = activation_time;
        this.position_in_menu = position_in_menu;
        this.active = active;
        modified = 1;
    }
}
