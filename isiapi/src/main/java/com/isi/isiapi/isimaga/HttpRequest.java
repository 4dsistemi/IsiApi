package com.isi.isiapi.isimaga;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.MagaProduct;
import com.isi.isiapi.general.classes.StorageRemovingElement;
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


    public ArrayList<MagaProduct> getProducts(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIMAGA, "getProducts", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIMAGA, "addProduct", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIMAGA, "modifyProduct", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIMAGA, "scaricoInUnit", json.getData(), apiKey, debug);

        try{

            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        }catch (Exception ignored){}

        return false;
    }

}


