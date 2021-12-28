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
import com.isi.isiapi.general.classes.IsifitAutocertificazionePremi;
import com.isi.isiapi.general.classes.IsifitRicevutaUtilizzoGratuito;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;

    private boolean debug = false;

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean addSport(String serial, IsiFitSport sport){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("sport", new Gson().toJsonTree(sport));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitSport", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "modifyIsiFitSport", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getSports", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitCausale", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addAutocertificazionePremi(String serial, IsifitAutocertificazionePremi causale){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("autocertificazione", new Gson().toJsonTree(causale));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addAutocertificazionePremi", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Log.e("TAG", "addAutocertificazionePremi: " + response);

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modifyCausale(IsiFitCausalePagamento causale){

        HttpJson json = new HttpJson();
        json.addData("causale", new Gson().toJsonTree(causale));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "modifyIsiFitCausale", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getCausali", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getCausali: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiFitCausalePagamento>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<IsifitAutocertificazionePremi> getAutocertificazionePremi(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getAutocertificazionePremi", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getCausali: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsifitAutocertificazionePremi>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean deleteSpesaPraticaSportiva(IsiFitSpesaPraticaSportiva spesa){

        HttpJson json = new HttpJson();
        json.addData("id", spesa.id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "deleteSpesaPraticaSportiva", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addSpesaPraticaSportiva(String serial, IsiFitSpesaPraticaSportiva spesa){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("spesa", new Gson().toJsonTree(spesa));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitSpesaPraticaSportiva", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsiFitSpesaPraticaSportivaMinori", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteSpesaPraticaSportivaMinori(IsiFitSpesaPraticaSportivaMinori spesa){

        HttpJson json = new HttpJson();
        json.addData("id", spesa.id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "deleteSpesaPraticaSportivaMinori", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addRicevutaOmaggio(String serial, IsifitRicevutaUtilizzoGratuito spesa){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("spesa", new Gson().toJsonTree(spesa));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsifitRicevutaUtilizzoGratuito", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Log.e("TAG", "addRicevutaOmaggio: " + response);

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<IsiFitSpesaPraticaSportiva> getSpesePraticheSportive(String serial, Date start,  Date end){

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("start", format.format(start));
        json.addData("end", format.format(end));


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getSpesePraticheSportive", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getCausali: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiFitSpesaPraticaSportiva>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<IsifitRicevutaUtilizzoGratuito> getRicevuteGratuite(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getRicevuteGratuite", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getCausali: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsifitRicevutaUtilizzoGratuito>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<IsiFitSpesaPraticaSportivaMinori> getSpesePraticheSportiveMinori(String serial, Date start,  Date end){

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());


        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("start", format.format(start));
        json.addData("end", format.format(end));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getSpesePraticheSportiveMinori", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "getCessioneBeni", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIFIT, "addIsifitCessioneBeni", json.getData(), apiKey, debug);

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




