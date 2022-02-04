package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiorderChat extends LastModifiedTables {

    @SerializedName("Id")
    public long id;

    @SerializedName("Arrival")
    public Date arrival = new Date();

    @SerializedName("FromId")
    public int from_id;

    @SerializedName("ToId")
    public int to_id;

    @SerializedName("Txt")
    public String txt;

    @SerializedName("Readed")
    public int readed = 0;

    @SerializedName("Active")
    public int active = 0;

    public IsiorderChat(int from_id, int to_id, String txt) {
        this.from_id = from_id;
        this.to_id = to_id;
        this.txt = txt;
    }
}
