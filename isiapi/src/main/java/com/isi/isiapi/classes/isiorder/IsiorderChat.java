package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiorderChat extends LastModifiedTables {

    
    public long id;

    
    public Date arrival = new Date();

    
    public int from_id;

    
    public int to_id;

    
    public String txt;

    
    public int readed = 0;

    
    public int active = 0;

    public IsiorderChat(int from_id, int to_id, String txt) {
        this.from_id = from_id;
        this.to_id = to_id;
        this.txt = txt;
    }
}
