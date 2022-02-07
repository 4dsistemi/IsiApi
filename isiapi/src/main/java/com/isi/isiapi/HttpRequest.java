package com.isi.isiapi;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.classes.Account;
import com.isi.isiapi.classes.AppActivation;
import com.isi.isiapi.classes.AppAndAppActivation;
import com.isi.isiapi.classes.Category;
import com.isi.isiapi.classes.CategoryAndProduct;
import com.isi.isiapi.classes.Commercial;
import com.isi.isiapi.classes.Customer;
import com.isi.isiapi.classes.Fattura;
import com.isi.isiapi.classes.FiscalPrinter;
import com.isi.isiapi.classes.GYBToken;
import com.isi.isiapi.classes.Product;
import com.isi.isiapi.classes.ThermalPrinter;
import com.isi.isiapi.classes.ctzon.CtzonOrder;
import com.isi.isiapi.classes.isicash.BillAndFattura;
import com.isi.isiapi.classes.isicash.IsiCashBill;
import com.isi.isiapi.classes.isicash.IsiCashBillAndElements;
import com.isi.isiapi.classes.isicash.IsiCashDepartment;
import com.isi.isiapi.classes.isiorder.IsiorderAccount;
import com.isi.isiapi.classes.isiorder.IsiorderCategoriesProductsNotes;
import com.isi.isiapi.classes.isiorder.IsiorderCategoryAndTables;
import com.isi.isiapi.classes.isiorder.IsiorderChatAccounts;
import com.isi.isiapi.classes.isiorder.IsiorderElementOrder;
import com.isi.isiapi.classes.isiorder.IsiorderNote;
import com.isi.isiapi.classes.isiorder.IsiorderOrdersProductElement;
import com.isi.isiapi.classes.isiorder.IsiorderTableCategory;
import com.isi.isiapi.classes.isiorder.IsiorderTableElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpRequest {

    private final String apiKey;

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public Commercial getCommercial(){

        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getCommercial", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, Commercial.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<Account> getAccount(){

        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getAccount", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Account>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<AppAndAppActivation> getApplicationActive(){

        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getApplicationActive", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, new TypeToken<ArrayList<AppAndAppActivation>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean removeShadow(AppActivation appActivation, int position){

        HttpJson json = new HttpJson();
        json.addData("id", appActivation.id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost( "removeShadow", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addShadow(AppActivation appActivation){

        HttpJson json = new HttpJson();
        json.addData("id", appActivation.id);

        MakeHttpPost post = new MakeHttpPost( "addShadow", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public int activateService(int id, int position){

        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost( "activateService", json.getData(), apiKey);

        try {
            String response = post.post();

            if(response.trim().equals("ok")) {
                return 1;
            }

            return 0;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;

    }

    public boolean updateApplicationActivePriority(ArrayList<AppAndAppActivation> activations){

        HttpJson json = new HttpJson();
        json.addData("applications", new Gson().toJsonTree(activations));

        MakeHttpPost post = new MakeHttpPost( "updateApplicationActivePriority", json.getData(), apiKey);

        try {
            String response = post.post();

            Log.e("TAG", "updateApplicationActivePriority: " + response);

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean removeAppActivation(AppActivation appActivation){

        HttpJson json = new HttpJson();
        json.addData("id", appActivation.id);

        MakeHttpPost post = new MakeHttpPost( "removeAppActivation", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean setPositionInMenu(AppActivation appActivation, int position){

        HttpJson json = new HttpJson();
        json.addData("id", appActivation.id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost( "setPositionInMenu", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateLocation(double lat, double lon){

        HttpJson json = new HttpJson();
        json.addData("lat", lat);
        json.addData("lon", lon);

        MakeHttpPost post = new MakeHttpPost( "updateLocation", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateNfc(Account account, String nfc){

        HttpJson json = new HttpJson();
        json.addData("id", account.id);
        json.addData("nfc", nfc);

        MakeHttpPost post = new MakeHttpPost( "updateNfc", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    //ISICASHIER

    public boolean addDepartment(IsiCashDepartment department){

        HttpJson json = new HttpJson();
        json.addData("department", new Gson().toJsonTree(department));

        MakeHttpPost post = new MakeHttpPost( "addDepartment", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editDepartment(IsiCashDepartment department){

        HttpJson json = new HttpJson();
        json.addData("department", new Gson().toJsonTree(department));

        MakeHttpPost post = new MakeHttpPost( "editDepartment", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<IsiCashDepartment> getDepartment(){
        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getDepartment", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiCashDepartment>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addCategory(Category department){

        HttpJson json = new HttpJson();
        json.addData("category", new Gson().toJsonTree(department));

        MakeHttpPost post = new MakeHttpPost( "addCategory", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editcategory(Category category){

        HttpJson json = new HttpJson();
        json.addData("category", new Gson().toJsonTree(category));

        MakeHttpPost post = new MakeHttpPost( "editCategory", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addProduct(Product product){

        HttpJson json = new HttpJson();
        json.addData("product", new Gson().toJsonTree(product));

        MakeHttpPost post = new MakeHttpPost( "addProduct", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editProduct(Product product){

        HttpJson json = new HttpJson();
        json.addData("product", new Gson().toJsonTree(product));

        MakeHttpPost post = new MakeHttpPost( "editProduct", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteProduct(Product product){

        HttpJson json = new HttpJson();
        json.addData("product", new Gson().toJsonTree(product));

        MakeHttpPost post = new MakeHttpPost( "addProduct", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<CategoryAndProduct> getCategories(){
        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getCategories", json.getData(), apiKey);

        try {
            String response = post.post();

            Log.e("TAG", "getCategories: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<CategoryAndProduct>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<FiscalPrinter> getFiscalPrinter(){
        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getFiscalPrinter", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, new TypeToken<ArrayList<FiscalPrinter>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addFiscalPrinter(FiscalPrinter printer){

        HttpJson json = new HttpJson();
        json.addData("printer", new Gson().toJsonTree(printer));

        MakeHttpPost post = new MakeHttpPost( "addFiscalPrinter", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editFiscalPrinter(FiscalPrinter printer){

        HttpJson json = new HttpJson();
        json.addData("printer", new Gson().toJsonTree(printer));

        MakeHttpPost post = new MakeHttpPost( "editFiscalPrinter", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addGybToken(GYBToken token){

        HttpJson json = new HttpJson();
        json.addData("token", new Gson().toJsonTree(token));

        MakeHttpPost post = new MakeHttpPost( "addGybToken", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public GYBToken getGybToken(){

        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getGybToken", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, GYBToken.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addBill(IsiCashBillAndElements bill){

        HttpJson json = new HttpJson();
        json.addData("bill", new Gson().toJsonTree(bill));

        MakeHttpPost post = new MakeHttpPost( "addBill", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<IsiCashBillAndElements> getBill(Date start, Date to){

        HttpJson json = new HttpJson();
        json.addData("start", start.getTime());
        json.addData("to", to.getTime());

        MakeHttpPost post = new MakeHttpPost( "getIsicashierBills", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, new TypeToken<ArrayList<IsiCashBillAndElements>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean updateBill(IsiCashBill bill){

        HttpJson json = new HttpJson();
        json.addData("bill", new Gson().toJsonTree(bill));

        MakeHttpPost post = new MakeHttpPost( "updateBill", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addFattura(IsiCashBillAndElements bill, Fattura fattura){

        HttpJson json = new HttpJson();
        json.addData("bill", new Gson().toJsonTree(bill));
        json.addData("fattura", new Gson().toJsonTree(fattura));

        MakeHttpPost post = new MakeHttpPost( "addBill", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<BillAndFattura> getFatture(){
        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getFatture", json.getData(), apiKey);

        try {
            String response = post.post();

            Log.e("TAG", "getFatture: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<BillAndFattura>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteFattura(Fattura fattura){

        HttpJson json = new HttpJson();
        json.addData("fattura", new Gson().toJsonTree(fattura));

        MakeHttpPost post = new MakeHttpPost( "deleteFattura", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateFattura(Fattura fattura){

        HttpJson json = new HttpJson();
        json.addData("fattura", new Gson().toJsonTree(fattura));

        MakeHttpPost post = new MakeHttpPost( "updateFattura", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<Customer> getCustomers(){
        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost( "getCustomers", json.getData(), apiKey);

        try {
            String response = post.post();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Customer>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addCustomer(Customer customer){

        HttpJson json = new HttpJson();
        json.addData("customer", new Gson().toJsonTree(customer));

        MakeHttpPost post = new MakeHttpPost( "addCustomer", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editCustomer(Customer customer){

        HttpJson json = new HttpJson();
        json.addData("customer", new Gson().toJsonTree(customer));

        MakeHttpPost post = new MakeHttpPost( "editCustomer", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteCustomer(Customer customer){

        HttpJson json = new HttpJson();
        json.addData("customer", new Gson().toJsonTree(customer));

        MakeHttpPost post = new MakeHttpPost( "deleteCustomer", json.getData(), apiKey);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    //ISIORDER

    public ArrayList<IsiorderAccount> getAccounts(){
        ArrayList<IsiorderAccount> accounts = new ArrayList<>();
        try {
            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "isiorderUser", json.getData(), apiKey);

            String result = post.post();

            accounts = new Gson().fromJson(result, new TypeToken<ArrayList<IsiorderAccount>>(){}.getType());

        } catch (Exception ignored) {

        }
        return accounts;
    }

    public IsiorderOrdersProductElement getOrderForTable(int table){
        try{
            HttpJson json = new HttpJson();
            json.addData("id", table);

            MakeHttpPost post = new MakeHttpPost( "getOrderForTable", json.getData(), apiKey);

            String result = post.post();

            return new Gson().fromJson(result, IsiorderOrdersProductElement.class);

        }catch (Exception ignored){

        }

        return null;
    }

    public ArrayList<IsiorderCategoriesProductsNotes> getElements(){

        ArrayList<IsiorderCategoriesProductsNotes> ctageories = new ArrayList<>();

        try {
            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "needToUpdate", json.getData(), apiKey);

            String result = post.post();

            ctageories = new Gson().fromJson(result, new TypeToken<ArrayList<IsiorderCategoriesProductsNotes>>(){}.getType());

        } catch (Exception ignored) {

        }

        return ctageories;

    }

    public boolean cancelOrderGuest(int id){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);

            MakeHttpPost post = new MakeHttpPost( "cancelOrderGuest", json.getData(), apiKey);

            String result = post.post();

            return result.contains("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean sendDelivery(String jsona, String elements, int operator){

        try {

            HttpJson json = new HttpJson();
            json.addData("json", jsona);
            json.addData("elements", elements);
            json.addData("operator", operator);

            MakeHttpPost post = new MakeHttpPost( "sendDelivery", json.getData(), apiKey);

            String result = post.post();

            return result.contains("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public ArrayList<CtzonOrder> getMyIsiDel(){

        ArrayList<CtzonOrder> missions = new ArrayList<>();

        try {

            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "getMyIsiDel", json.getData(), apiKey);

            String result = post.post();

            if(result.trim().equals("notActive")){
                return missions;
            }

            missions = new Gson().fromJson(result, new TypeToken<ArrayList<CtzonOrder>>(){}.getType());

        } catch (Exception ignored) {

        }

        return missions;

    }

    public boolean confirmIsiDel(String id, boolean confirm, boolean isidel){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            json.addData("confirm", confirm);
            json.addData("isidel", isidel);
            MakeHttpPost post = new MakeHttpPost( "confirmIsiDel", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean updateStatus(int id, int status){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            json.addData("status", status);
            MakeHttpPost post = new MakeHttpPost( "updateStatusDelivery", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public void occupingTable(int id, int operator){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            json.addData("account", operator);
            MakeHttpPost post = new MakeHttpPost( "occupingTable", json.getData(), apiKey);

            String result = post.post();

        } catch (Exception ignored) {

        }
    }

    public void releaseTable(int id){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            MakeHttpPost post = new MakeHttpPost( "releaseTable", json.getData(), apiKey);

            String result = post.post();

        } catch (Exception ignored) {

        }

    }

    public boolean checkisiDel(){

        try {

            HttpJson json = new HttpJson();
            MakeHttpPost post = new MakeHttpPost( "getMyIsiDel", json.getData(), apiKey);

            String result = post.post();

            return !result.trim().equals("notActive");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean reopenOrder(int id){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            MakeHttpPost post = new MakeHttpPost( "reopenOrder", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean updateElementAlreadySent(IsiorderElementOrder element){
        try {

            HttpJson json = new HttpJson();
            json.addData("id", element.id);
            json.addData("newName", element.newName);
            json.addData("newPrice", element.newPrice);

            MakeHttpPost post = new MakeHttpPost( "changeElementAlreadySent", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<ThermalPrinter> getIsiOrderPrinter(){

        try {
            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "getPrinters", json.getData(), apiKey);

            String result = post.post();

            return new Gson().fromJson(result, new TypeToken<ArrayList<ThermalPrinter>>(){}.getType());
        } catch (Exception ignored) {

        }

        return null;

    }

    public ArrayList<IsiorderCategoryAndTables> getCategoriesTables(){

        try {
            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "tables", json.getData(), apiKey);

            String result = post.post();

            return new Gson().fromJson(result, new TypeToken<ArrayList<IsiorderCategoryAndTables>>(){}.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean canAccess(int id){
        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            MakeHttpPost post = new MakeHttpPost( "canAccess", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public JsonObject IsiorderSendOrder(IsiorderOrdersProductElement isiorderOrdersProductElement, boolean stamp){
        try {

            HttpJson json = new HttpJson();
            json.addData("order", new Gson().toJsonTree(isiorderOrdersProductElement));
            json.addData("stamp", stamp);
            MakeHttpPost post = new MakeHttpPost( "sendOrder", json.getData(), apiKey);

            String result = post.post();

            return new JsonObject().getAsJsonObject(result);

        } catch (Exception ignored) {

        }

        return new JsonObject();
    }

    public boolean printPrebuill(int id, boolean discount_auto, boolean romana, boolean all){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            json.addData("discount_auto", id);
            json.addData("romana", id);
            json.addData("all", id);

            MakeHttpPost post = new MakeHttpPost( "printPrebill", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean setRomanaPayedElement(int orderId, boolean stamp, int account_id, float discount, float total, int peopleSelected){
        try {

            HttpJson json = new HttpJson();
            json.addData("order_id", orderId);
            json.addData("stamp", stamp);
            json.addData("account_id", account_id);
            json.addData("discount", discount);
            json.addData("total", total);
            json.addData("people", peopleSelected);

            MakeHttpPost post = new MakeHttpPost( "setRomanaPayedElement", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean setPayedElement(ArrayList<Integer> ids, int orderId, boolean stamp, int account_id, float discount, float total){
        try {

            HttpJson json = new HttpJson();
            json.addData("id", new Gson().toJsonTree(ids));
            json.addData("order_id", orderId);
            json.addData("stamp", stamp);
            json.addData("account_id", account_id);
            json.addData("discount", discount);
            json.addData("total", total);

            MakeHttpPost post = new MakeHttpPost( "setPayedElements", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean setReadedMessages(int toId){
        try {

            HttpJson json = new HttpJson();
            json.addData("to_id", toId);
            MakeHttpPost post = new MakeHttpPost( "setReadedMessages", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<IsiorderChatAccounts> getAllMyMessages(int myId){

        try {
            HttpJson json = new HttpJson();

            json.addData("myId", myId);

            MakeHttpPost post = new MakeHttpPost( "getAllMyMessages", json.getData(), apiKey);

            String result = post.post();

            return new Gson().fromJson(result, new TypeToken<ArrayList<IsiorderChatAccounts>>(){}.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean deleteChat(int fromId, int toId){

        try {

            HttpJson json = new HttpJson();
            json.addData("from_id", fromId);
            json.addData("to_id", toId);

            MakeHttpPost post = new MakeHttpPost( "deleteChat", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean sendMessageToPrinter(int id, String text, int operator){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", id);
            json.addData("text", text);
            json.addData("operator", operator);

            MakeHttpPost post = new MakeHttpPost( "sendMessageToPrinter", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public ArrayList<IsiorderOrdersProductElement> getAllOrderToday(int myId){

        try {
            HttpJson json = new HttpJson();

            json.addData("myId", myId);

            MakeHttpPost post = new MakeHttpPost( "getAllOrderToday", json.getData(), apiKey);

            String result = post.post();

            return new Gson().fromJson(result, new TypeToken<ArrayList<IsiorderChatAccounts>>(){}.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean changeCoperti(int orderId, int coperti){

        try {

            HttpJson json = new HttpJson();
            json.addData("order_id", orderId);
            json.addData("coperti", coperti);

            MakeHttpPost post = new MakeHttpPost( "changeCoperti", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean moveTable(int order, int table){

        try {

            HttpJson json = new HttpJson();
            json.addData("order", order);
            json.addData("table", table);

            MakeHttpPost post = new MakeHttpPost( "moveTable", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean addSconto(int order, double sconto){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", order);
            json.addData("sconto", sconto);

            MakeHttpPost post = new MakeHttpPost( "addSconto", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean printExit(int order, int exit){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", order);
            json.addData("whatExit", exit);

            MakeHttpPost post = new MakeHttpPost( "printExit", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean cleanTable(int account_id, int order, boolean stamp, float discount, float total, String ctzonCard){

        try {

            HttpJson json = new HttpJson();
            json.addData("account_id", account_id);
            json.addData("id", order);
            json.addData("stamp", stamp);
            json.addData("discount", discount);
            json.addData("total", total);
            json.addData("ctzonCard", ctzonCard);


            MakeHttpPost post = new MakeHttpPost( "cleanTable", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("tableCleaned");

        } catch (Exception ignored) {

        }

        return false;

    }

    public float getCopertiCost(){
        try {

            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "getCopertiCost", json.getData(), apiKey);

            String result = post.post();

            return Float.parseFloat(result.trim());

        } catch (Exception ignored) {

        }

        return 0;
    }

    public boolean getChatService(){

        try {

            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "getChatService", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("activated");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean addMessageChat(int account_id, int friend_id,  String message){

        try {

            HttpJson json = new HttpJson();
            json.addData("id", account_id);
            json.addData("friendId", friend_id);
            json.addData("txt", message);

            MakeHttpPost post = new MakeHttpPost( "addMessageChat", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("arrived");

        } catch (Exception ignored) {

        }

        return false;

    }

    public String getChatMessage(int myId, int friend_id){
        try {

            HttpJson json = new HttpJson();
            json.addData("myId", myId);
            json.addData("friendId", friend_id);

            MakeHttpPost post = new MakeHttpPost( "getChatMessage", json.getData(), apiKey);

            return post.post();

        } catch (Exception ignored) {

        }

        return new JsonObject().toString();
    }

    public boolean isiorderAddTable(IsiorderTableElement element){
        try {

            HttpJson json = new HttpJson();
            json.addData("table", element);
            MakeHttpPost post = new MakeHttpPost( "isiorderAddTable", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderEditTable(IsiorderTableElement element){
        try {

            HttpJson json = new HttpJson();
            json.addData("table", element);
            MakeHttpPost post = new MakeHttpPost( "isiorderEditTable", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderAddCategoryTable(IsiorderTableCategory element){
        try {

            HttpJson json = new HttpJson();
            json.addData("category", element);
            MakeHttpPost post = new MakeHttpPost( "isiorderAddCategoryTable", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderEditCategoryTable(IsiorderTableCategory element){
        try {

            HttpJson json = new HttpJson();
            json.addData("category", element);
            MakeHttpPost post = new MakeHttpPost( "isiorderEditCategoryTable", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderAddNote(IsiorderNote element){
        try {

            HttpJson json = new HttpJson();
            json.addData("note", element);
            MakeHttpPost post = new MakeHttpPost( "isiorderAddNote", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderEditNote(IsiorderNote element){
        try {

            HttpJson json = new HttpJson();
            json.addData("note", element);
            MakeHttpPost post = new MakeHttpPost( "isiorderEditNote", json.getData(), apiKey);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<IsiorderNote> isiorderGetNotes(){

        try {
            HttpJson json = new HttpJson();

            MakeHttpPost post = new MakeHttpPost( "isiorderGetNotes", json.getData(), apiKey);

            String result = post.post();

            return new Gson().fromJson(result, new TypeToken<ArrayList<IsiorderNote>>(){}.getType());
        } catch (Exception ignored) {

        }

        return null;


    }


}


