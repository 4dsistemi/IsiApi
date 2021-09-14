package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

//Classe relativa ad una chiusura straordinaria
public class ShopExtraClosing {
    @SerializedName("Id")
    private final int id;
    @SerializedName("CommercialLocalId")
    private String commercialLocalId;
    @SerializedName("Start")
    private Date start;
    @SerializedName("End")
    private Date end;
    @SerializedName("Description")
    private String description;

    public ShopExtraClosing()
    {
        //settiamo il valore a 0 per avere un default
        id = 0;
    }

    public ShopExtraClosing(int id, String commercialLocalId, Date start, Date end, String description)
    {
        this.id = id;
        this.commercialLocalId = commercialLocalId;
        this.start = start;
        this.end = end;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCommercialLocalId() {
        return commercialLocalId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
