package com.isi.isiapi.isifit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.IsiFitCausalePagamento;
import com.isi.isiapi.general.classes.IsiFitCessioneBeni;
import com.isi.isiapi.general.classes.IsiFitSpesaPraticaSportiva;
import com.isi.isiapi.general.classes.IsiFitSpesaPraticaSportivaMinori;
import com.isi.isiapi.general.classes.IsiFitSport;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean addSport(String serial, IsiFitSport sport){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("sport", new Gson().toJsonTree(sport));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitSport", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modifySport(IsiFitSport sport){

        HttpJson json = new HttpJson();
        json.addData("sport", new Gson().toJsonTree(sport));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "modifyIsiFitSport", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<IsiFitSport> getSports(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getSports", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getSports: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiFitSport>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addCausale(String serial, IsiFitCausalePagamento causale){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("causale", new Gson().toJsonTree(causale));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitCausale", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modifyCausale(IsiFitCausalePagamento causale){

        HttpJson json = new HttpJson();
        json.addData("causale", new Gson().toJsonTree(causale));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "modifyIsiFitCausale", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<IsiFitCausalePagamento> getCausali(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getCausali", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getCausali: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiFitCausalePagamento>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addSpesaPraticaSportiva(String serial, IsiFitSpesaPraticaSportiva spesa){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("spesa", new Gson().toJsonTree(spesa));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitSpesaPraticaSportiva", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addSpesaPraticaSportivaMinori(String serial, IsiFitSpesaPraticaSportivaMinori spesa){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("spesa", new Gson().toJsonTree(spesa));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitSpesaPraticaSportivaMinori", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<IsiFitSpesaPraticaSportiva> getSpesePraticheSportive(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getSpesePraticheSportive", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getCausali: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiFitSpesaPraticaSportiva>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<IsiFitSpesaPraticaSportivaMinori> getSpesePraticheSportiveMinori(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getSpesePraticheSportiveMinori", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getSpese: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiFitSpesaPraticaSportivaMinori>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }


    public ArrayList<IsiFitCessioneBeni> getCessioneBeni(String serial) {

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getCessioneBeni", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getSpese: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiFitCessioneBeni>>() {
            }.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }
    public boolean addCessioneBeni(String serial, IsiFitCessioneBeni spesa){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("beni", new Gson().toJsonTree(spesa));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsifitCessioneBeni", json.getData(), apiKey, true);

        try {
            String response = post.execute().get();

            Log.e("TAG", "addCessioneBeni: " + response);

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

}


