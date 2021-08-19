package com.isi.isiapi.isimaga;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.MagaProduct;
import com.isi.isiapi.general.classes.StorageRemovingElement;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;

    @Deprecated
    public HttpRequest(String serial, String apiKey) {
        this.apiKey = apiKey;
    }


    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }


    public ArrayList<MagaProduct> getProducts(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getProducts", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<MagaProduct>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addProduct(String serial, MagaProduct product){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("product", new Gson().toJsonTree(product));

        MakeHttpPost post = new MakeHttpPost("addProduct", json.getData(), apiKey);

        try{

            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        }catch (Exception ignored){}

        return false;

    }

    public boolean modifyPorduct(String serial, MagaProduct product){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("product", new Gson().toJsonTree(product));

        MakeHttpPost post = new MakeHttpPost("modifyProduct", json.getData(), apiKey);

        try{

            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        }catch (Exception ignored){}

        return false;
    }

    public boolean scaricoInUnit(ArrayList<StorageRemovingElement> elements){
        HttpJson json = new HttpJson();
        json.addData("to_remove", new Gson().toJsonTree(elements));

        MakeHttpPost post = new MakeHttpPost("scaricoInUnit", json.getData(), apiKey);

        try{

            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        }catch (Exception ignored){}

        return false;
    }

}


