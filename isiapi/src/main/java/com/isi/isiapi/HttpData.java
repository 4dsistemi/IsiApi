package com.isi.isiapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class HttpData {

    
    public final String intent;
    
    public final JsonObject data;

    public HttpData(String intent, JsonObject data) {
        this.intent = intent;
        this.data = data;
    }

    public String generateJson(HttpData data){

        Gson g = new GsonBuilder().serializeNulls().create();
        return g.toJson(data);

    }
}
