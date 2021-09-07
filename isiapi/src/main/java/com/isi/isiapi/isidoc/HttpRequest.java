package com.isi.isiapi.isidoc;

import com.google.gson.Gson;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.Customer;
import com.isi.isiapi.general.classes.IsiDocResponse;

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

    public IsiDocResponse getMyDoc(Customer c){
        HttpJson json = new HttpJson();
        json.addData("customer", c.getId());

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIDOC, "checkDocCustomer", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, IsiDocResponse.class);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

}


