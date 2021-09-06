package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class IsiFitCausalePagamento {

    @SerializedName("Id")
    public int id;
    @SerializedName("Causale")
    public String causale;
    @SerializedName("Active")
    public int active = 1;
    @SerializedName("CommercialLocalId")
    public String commercialLocalId;

    public IsiFitCausalePagamento(String causale) {
        this.causale = causale;
    }

    @Override
    public String toString() {
        return causale;
    }
}
