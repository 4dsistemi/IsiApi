package com.isi.isiapi.isishop;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.AdditionaInformation;
import com.isi.isiapi.general.classes.CommercialCategory;
import com.isi.isiapi.general.classes.ShopDetail;
import com.isi.isiapi.general.classes.ShopExtraClosing;
import com.isi.isiapi.general.classes.ShopOpeningHours;

import java.util.ArrayList;

public class HttpRequest {

    private final String apiKey;
    private boolean debug = false;

    @Deprecated
    public HttpRequest(String serial, String apiKey) {
        this.apiKey = apiKey;
    }

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public ShopDetail getLocalInfo(String serial) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP, "getSerial", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, ShopDetail.class);
        } catch (Exception e) {
            return null;
        }

    }

    public boolean editShopInfo(String serial, ShopDetail shopDetail) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("shopData", new Gson().toJsonTree(shopDetail));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"editShopInfo", json.getData(), apiKey, debug);

        try {

            String response = post.execute().get();
            return response.trim().equals("ok");

        } catch (Exception ignored) {
            return false;
        }
    }

    public ArrayList<ShopOpeningHours> getOpeningHours(String serial) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getOpeningHours", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return new Gson().fromJson(response, new TypeToken<ArrayList<ShopOpeningHours>>() {
            }.getType());
        } catch (Exception e) {
            //preferisco restituire una lista vuota che null
            return new ArrayList<>();
        }
    }

    public boolean editOpeningHours(String serial, ShopOpeningHours openingHours) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("openingHours", new Gson().toJsonTree(openingHours));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"editOpeningHours", json.getData(), apiKey, debug);

        try {

            String response = post.execute().get();
            return response.trim().equals("ok");

        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean addOpeningHours(String serial, ShopOpeningHours openingHours) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("openingHours", new Gson().toJsonTree(openingHours));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"addOpeningHours", json.getData(), apiKey, debug);

        try {

            String response = post.execute().get();
            return response.trim().equals("ok");

        } catch (Exception ignored) {
            return false;
        }


    }

    public boolean deleteOpeningHours(String serial, int id) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("id", new Gson().toJsonTree(id));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"deleteOpeningHours", json.getData(), apiKey, debug);

        try {

            String response = post.execute().get();
            return response.trim().equals("ok");

        } catch (Exception ignored) {
            return false;
        }
    }

    public ArrayList<ShopExtraClosing> getExtraClosings(String serial) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getExtraordinaryClosing", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return new Gson().fromJson(response, new TypeToken<ArrayList<ShopExtraClosing>>() {
            }.getType());
        } catch (Exception e) {
            //preferisco restituire una lista vuota
            return new ArrayList<>();
        }
    }

    public boolean editExtraClosing(String serial, ShopExtraClosing openingHours) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("extraClosing", new Gson().toJsonTree(openingHours));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"editExtraordinaryClosing", json.getData(), apiKey, debug);

        try {

            String response = post.execute().get();
            return response.trim().equals("ok");
        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean addExtraClosing(String serial, ShopExtraClosing shopExtraClosing) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("extraClosing", new Gson().toJsonTree(shopExtraClosing));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"addExtraordinaryClosing", json.getData(), apiKey, debug);

        try {

            String response = post.execute().get();
            return response.trim().equals("ok");

        } catch (Exception ignored) {
            return false;
        }
    }

    public boolean deleteExtraClosing(String serial, int id) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("id", new Gson().toJsonTree(id));

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"deleteExtraordinaryClosing", json.getData(), apiKey, debug);

        try {

            String response = post.execute().get();
            return response.trim().equals("ok");

        } catch (Exception ignored) {
            return false;
        }
    }

    public ArrayList<AdditionaInformation> getCommonAdditionalInformations(String serial) {
        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getCommonAdditionalInformation", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return new Gson().fromJson(response, new TypeToken<ArrayList<AdditionaInformation>>() {
            }.getType());
        } catch (Exception e) {
            //preferiscono restituire una lista vuota
            return new ArrayList<>();
        }
    }

    public ArrayList<AdditionaInformation> getCommonAdditionalInformationsForCommercial(String serial) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getCommonAdditionalInformationForCommercial", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return new Gson().fromJson(response, new TypeToken<ArrayList<AdditionaInformation>>() {
            }.getType());
        } catch (Exception e) {
            //preferiscono restituire una lista vuota
            return new ArrayList<>();
        }
    }

    public ArrayList<AdditionaInformation> getAdditionalInformations(String serial, int idCategory) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("commercialCategory", idCategory);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getAdditionalInformationByCommercialCategory", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return new Gson().fromJson(response, new TypeToken<ArrayList<AdditionaInformation>>() {
            }.getType());
        } catch (Exception e) {
            //preferiscono restituire una lista vuota
            return new ArrayList<>();
        }
    }

    public ArrayList<AdditionaInformation> getAdditionalInformationsForCommercial(String serial, int idCategory) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("commercialCategory", idCategory);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getAdditionalInformationForCommercial", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return new Gson().fromJson(response, new TypeToken<ArrayList<AdditionaInformation>>() {
            }.getType());
        } catch (Exception e) {
            //preferiscono restituire una lista vuota
            return new ArrayList<>();
        }
    }

    public boolean updateCommonAdditionalInformationsForCommercial(String serial, int additionalInfoId, String note, int attivo)
    {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("additionalInfoId", additionalInfoId);
        json.addData("note", note);
        json.addData("selected", attivo);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"setCommonAdditionalInformationForCommercial", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return response.trim().equals("ok");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateAdditionalInformationsForCommercial(String serial, int additionalInfoId, int commercialCategoryId, String note, int attivo)
    {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("additionalInfoId", additionalInfoId);
        json.addData("note", note);
        json.addData("commercialCategoryId", commercialCategoryId);
        json.addData("selected", attivo);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"setAdditionalInformationForCommercial", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return response.trim().equals("ok");
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<CommercialCategory> getCommercialCategories(String serial) {
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getCommercialCategories", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return new Gson().fromJson(response, new TypeToken<ArrayList<CommercialCategory>>() {
            }.getType());
        } catch (Exception e) {
            //preferiscono restituire una lista vuota
            return new ArrayList<>();
        }
    }

    public ArrayList<CommercialCategory> getAllCategories(String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"getAllCategories", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            Log.e("TAG", "getAllCategories: " + response);
            return new Gson().fromJson(response, new TypeToken<ArrayList<CommercialCategory>>() {
            }.getType());
        } catch (Exception e) {
            //preferiscono restituire una lista vuota
            return new ArrayList<>();
        }
    }

    public boolean addCategory(int id, String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"addCategory", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return response.trim().equals("ok");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeCategory(int id, String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISISHOP,"deleteCategory", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();
            return response.trim().equals("ok");
        } catch (Exception e) {
            return false;
        }
    }
}


