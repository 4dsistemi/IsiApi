package com.isi.isiapi.isichain;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.Forniture;
import com.isi.isiapi.general.classes.MagaProduct;
import com.isi.isiapi.general.classes.OrderForniture;
import com.isi.isiapi.general.classes.OrderForniturePropel;

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


    public ArrayList<Forniture> getForniture(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getForniture", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Forniture>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addOrderToForniture(String serial, OrderForniture order){

        HttpJson json = new HttpJson();
        json.addData("order", new Gson().toJsonTree(order));
        json.addData("serial", serial);

        Log.e("TAG", "addOrderToForniture: " + json.getData());

        MakeHttpPost post = new MakeHttpPost("addOrderToForniture", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            Log.e("TAG", "addOrderToForniture: " + response);

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateForniture(Forniture f){

        HttpJson json = new HttpJson();
        json.addData("forniture", new Gson().toJsonTree(f));

        MakeHttpPost post = new MakeHttpPost("updateForniture", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            Log.e("TAG", "updateForniture: " + response);

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<OrderForniturePropel> getOrdersForniture(String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getOrderForniture", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getOrdersForniture: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<OrderForniturePropel>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addFonriture(String serial, Forniture forniture){
        HttpJson json = new HttpJson();
        json.addData("forniture", new Gson().toJsonTree(forniture));
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("addForniture", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            Log.e("TAG", "updateForniture: " + response);

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

}


