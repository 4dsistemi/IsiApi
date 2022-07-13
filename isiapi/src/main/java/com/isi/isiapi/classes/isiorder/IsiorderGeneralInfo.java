package com.isi.isiapi.classes.isiorder;


import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderGeneralInfo extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("OrderGuest")
    public long order_guest = 0;

    @SerializedName("ReservationService")
    public long reservation_service = 0;

    @SerializedName("ChatService")
    public long chat_service = 0;

    @SerializedName("IsidelService")
    public long isidel_service = 0;

    @SerializedName("MaxNumberOfPeople")
    public int max_number_of_people = 0;

    @SerializedName("Coperto")
    public float coperto = 0;

    @SerializedName("FreeDraw")
    public boolean FreeDraw = false;

}
