package com.isi.isiapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class HttpJson {

    private final JsonObject json;

    public HttpJson() {
        this.json = new JsonObject();
    }

    public void addData(String name, Object variable){

        if(variable == null){
            json.add(name, null);
        }else{
            if(variable instanceof JsonElement){
                json.add(name, (JsonElement)variable);
            }else{
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
                json.add(name, gson.toJsonTree(variable));
            }
        }


    }

    public JsonObject getData(){
        return json;
    }
}