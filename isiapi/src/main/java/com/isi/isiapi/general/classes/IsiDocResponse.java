package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class IsiDocResponse {

    @SerializedName("ci")
    public boolean ci;
    @SerializedName("patente")
    public boolean patente;
    @SerializedName("passaport")
    public boolean passaporto;
    @SerializedName("tessera_sanitaria")
    public boolean tessera_sanitaria;

    public IsiDocResponse(boolean ci, boolean patente, boolean passaporto, boolean tessera_sanitaria) {
        this.ci = ci;
        this.patente = patente;
        this.passaporto = passaporto;
        this.tessera_sanitaria = tessera_sanitaria;
    }
}
