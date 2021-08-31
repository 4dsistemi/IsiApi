package com.isi.isiapi.general.classes.ctzon;

import com.google.gson.annotations.SerializedName;

public class LoyaltyPoint {

    @SerializedName("Id")
    public int id;
    @SerializedName("Points")
    public int points;
    @SerializedName("AccountId")
    public int accountId;
    @SerializedName("CommercialLocalid")
    public String commercialLocalId;

    public LoyaltyPoint(int id, int points, int accountId, String commercialLocalId) {
        this.id = id;
        this.points = points;
        this.accountId = accountId;
        this.commercialLocalId = commercialLocalId;
    }
}
