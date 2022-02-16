package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IsiorderGuestOrderElementNote {

    public IsiorderGuestOrder isiorderGuestOrder;
    @SerializedName("IsiorderGuestOrderElements")
    public List<IsiorderGuestElementNote> isiorderGuestElementNotes;

}
