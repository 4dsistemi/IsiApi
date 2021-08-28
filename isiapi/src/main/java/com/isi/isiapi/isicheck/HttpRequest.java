package com.isi.isiapi.isicheck;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.IsiCheckSocieties;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;
    private boolean debug = false;

    @Deprecated
    public HttpRequest(String serial, String apiKey) {
        this.apiKey = apiKey;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }


    public ArrayList<IsiCheckSocieties> getSocieties(){

        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICHECK, "getSocieties", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiCheckSocieties>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

}


