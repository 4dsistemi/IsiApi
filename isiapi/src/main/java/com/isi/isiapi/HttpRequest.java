package com.isi.isiapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
import com.isi.isiapi.classes.Ingredients;
import com.isi.isiapi.classes.Product;
import com.isi.isiapi.classes.ThermalPrinter;
import com.isi.isiapi.classes.ThermalPrinterAndCategories;
import com.isi.isiapi.classes.ThermalPrinterCategory;
import com.isi.isiapi.classes.ThermalPrinterSubcategory;
import com.isi.isiapi.classes.ctzon.CtzonOrder;
import com.isi.isiapi.classes.isicash.BillAndFattura;
import com.isi.isiapi.classes.isicash.IsiCashBill;
import com.isi.isiapi.classes.isicash.IsiCashBillAndElements;
import com.isi.isiapi.classes.isicash.IsiCashDepartment;
import com.isi.isiapi.classes.isimaga.Forniture;
import com.isi.isiapi.classes.isimaga.IsimagaPorductMovement;
import com.isi.isiapi.classes.isimaga.OrderToForniture;
import com.isi.isiapi.classes.isimaga.OrderToFornitureElement;
import com.isi.isiapi.classes.isimaga.OrdersAndForniture;
import com.isi.isiapi.classes.isimaga.ProductForniture;
import com.isi.isiapi.classes.isiorder.CategoriesTableResponse;
import com.isi.isiapi.classes.isiorder.CategoryAndListini;
import com.isi.isiapi.classes.isiorder.DevicesAuthorization;
import com.isi.isiapi.classes.isiorder.IsiorderAccount;
import com.isi.isiapi.classes.isiorder.IsiorderCategoryAndTables;
import com.isi.isiapi.classes.isiorder.IsiorderChat;
import com.isi.isiapi.classes.isiorder.IsiorderChatAccounts;
import com.isi.isiapi.classes.isiorder.IsiorderElementOrder;
import com.isi.isiapi.classes.isiorder.IsiorderGeneralInfo;
import com.isi.isiapi.classes.isiorder.IsiorderGuestOrder;
import com.isi.isiapi.classes.isiorder.IsiorderInformationOrders;
import com.isi.isiapi.classes.isiorder.IsiorderListini;
import com.isi.isiapi.classes.isiorder.IsiorderNote;
import com.isi.isiapi.classes.isiorder.IsiorderOrdersProductElement;
import com.isi.isiapi.classes.isiorder.IsiorderPrinterRulesAndCategories;
import com.isi.isiapi.classes.isiorder.IsiorderTableCategory;
import com.isi.isiapi.classes.isiorder.IsiorderTableElement;
import com.isi.isiapi.classes.isishop.CommercialCategoryAndMy;
import com.isi.isiapi.classes.isishop.ExtraordinaryClosing;
import com.isi.isiapi.classes.isishop.IsicoinMovement;
import com.isi.isiapi.classes.isishop.MyCommercialCategory;
import com.isi.isiapi.classes.isishop.OpeningHours;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpRequest {

    private final String apiKey;
    public static String serverIpAddress = "10.99.66.2";

    private final Commercial commercial;

    private final Gson gson;


    public HttpRequest(String apiKey, String ip, Commercial commercial) {
        this.apiKey = apiKey;
        this.commercial = commercial;
        serverIpAddress = ip;

        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

    }

    public List<Commercial> getCommercials(){
        HttpJson json = new HttpJson();

        MakeHttpPost post = new MakeHttpPost("getCommercials", json.getData(), apiKey, WebControllers.commercial);

        try {
            String response = post.post();
            return gson.fromJson(response, new TypeToken<ArrayList<Commercial>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Commercial getCommercial(){

        HttpJson json = new HttpJson();
        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getCommercial", json.getData(), "", WebControllers.isiapp);

        try {
            String response = post.post();
            return gson.fromJson(response, Commercial.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateCommercial(Commercial c) {

        HttpJson json = new HttpJson();
        json.addData("commercial", gson.toJsonTree(c));

        MakeHttpPost post = new MakeHttpPost("updateCommercial", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<Account> getAccount() {

        HttpJson json = new HttpJson();
        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getAccount", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<Account>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<AppAndAppActivation> getApplicationActive() {

        HttpJson json = new HttpJson();
        json.addData("commercial", this.commercial.local_id);


        MakeHttpPost post = new MakeHttpPost("getApplicationActive", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<AppAndAppActivation>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean removeShadow(AppActivation appActivation, int position) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", appActivation.id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost("removeShadow", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addShadow(AppActivation appActivation) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", appActivation.id);

        MakeHttpPost post = new MakeHttpPost("addShadow", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public int activateService(int id, int position) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost("activateService", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            if (response.trim().equals("ok")) {
                return 1;
            }

            return 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;

    }

    public boolean updateApplicationActivePriority(ArrayList<AppAndAppActivation> activations) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("applications", gson.toJsonTree(activations));

        MakeHttpPost post = new MakeHttpPost("updateApplicationActivePriority", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean removeAppActivation(AppActivation appActivation) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", appActivation.id);

        MakeHttpPost post = new MakeHttpPost("removeAppActivation", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean setPositionInMenu(AppActivation appActivation, int position) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", appActivation.id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost("setPositionInMenu", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateLocation(double lat, double lon) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("lat", lat);
        json.addData("lon", lon);

        MakeHttpPost post = new MakeHttpPost("updateLocation", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateNfc(Account account, String nfc) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", account.id);
        json.addData("nfc", nfc);

        MakeHttpPost post = new MakeHttpPost("updateNfc", json.getData(), apiKey, WebControllers.isiapp);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    //ISICASHIER

    public boolean addDepartment(IsiCashDepartment department) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("department", gson.toJsonTree(department));

        MakeHttpPost post = new MakeHttpPost("addDepartment", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editDepartment(IsiCashDepartment department) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("department", gson.toJsonTree(department));

        MakeHttpPost post = new MakeHttpPost("editDepartment", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<IsiCashDepartment> getDepartment() {
        HttpJson json = new HttpJson();
        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getDepartment", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<IsiCashDepartment>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addCategory(Category department) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("category", gson.toJsonTree(department));

        MakeHttpPost post = new MakeHttpPost("addCategory", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editcategory(Category category) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("category", gson.toJsonTree(category));

        MakeHttpPost post = new MakeHttpPost("editCategory", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addProduct(Product product, List<Ingredients> ingredients) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("product", gson.toJsonTree(product));
        json.addData("ingredients", gson.toJsonTree(ingredients));

        MakeHttpPost post = new MakeHttpPost("addProduct", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editProduct(Product product, List<Ingredients> ingredients) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("product", gson.toJsonTree(product));
        json.addData("ingredients", gson.toJsonTree(ingredients));

        MakeHttpPost post = new MakeHttpPost("editProduct", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteProduct(Product product) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("product", gson.toJsonTree(product));

        MakeHttpPost post = new MakeHttpPost("addProduct", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<CategoryAndListini> getCategories() {

        ArrayList<CategoryAndListini> ctageories = new ArrayList<>();

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getCategories", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            ctageories = gson.fromJson(result, new TypeToken<ArrayList<CategoryAndListini>>() {
            }.getType());

        } catch (Exception ignored) {

        }

        return ctageories;
    }

    public List<FiscalPrinter> getFiscalPrinter() {
        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getFiscalPrinter", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<FiscalPrinter>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addFiscalPrinter(FiscalPrinter printer) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("printer", gson.toJsonTree(printer));

        MakeHttpPost post = new MakeHttpPost("addFiscalPrinter", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editFiscalPrinter(FiscalPrinter printer) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("printer", gson.toJsonTree(printer));

        MakeHttpPost post = new MakeHttpPost("editFiscalPrinter", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addGybToken(GYBToken token) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("token", gson.toJsonTree(token));

        MakeHttpPost post = new MakeHttpPost("addGybToken", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public GYBToken getGybToken() {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getGybToken", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return gson.fromJson(response, GYBToken.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addBill(IsiCashBillAndElements bill, boolean scarico) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("bill", gson.toJsonTree(bill));
        json.addData("scarico", scarico);

        MakeHttpPost post = new MakeHttpPost("addBill", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<IsiCashBillAndElements> getBill(Date start, Date to) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("start", start.getTime());
        json.addData("to", to.getTime());

        MakeHttpPost post = new MakeHttpPost("getIsicashierBills", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<IsiCashBillAndElements>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean updateBill(IsiCashBill bill) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("bill", gson.toJsonTree(bill));

        MakeHttpPost post = new MakeHttpPost("updateBill", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addFattura(IsiCashBillAndElements bill, Fattura fattura, boolean scarico) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("bill", gson.toJsonTree(bill));
        json.addData("fattura", gson.toJsonTree(fattura));
        json.addData("scarico", scarico);

        MakeHttpPost post = new MakeHttpPost("addFattura", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<BillAndFattura> getFatture() {
        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getFatture", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<BillAndFattura>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteFattura(Fattura fattura) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("fattura", gson.toJsonTree(fattura));

        MakeHttpPost post = new MakeHttpPost("deleteFattura", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateFattura(Fattura fattura) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("fattura", gson.toJsonTree(fattura));

        MakeHttpPost post = new MakeHttpPost("updateFattura", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public List<Customer> getCustomers() {
        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getCustomers", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<Customer>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addCustomer(Customer customer) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("customer", gson.toJsonTree(customer));

        MakeHttpPost post = new MakeHttpPost("addCustomer", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean upsertCustomerBySociety(Customer customer) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("customer", gson.toJsonTree(customer));

        MakeHttpPost post = new MakeHttpPost("upsertCustomerBySociety", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editCustomer(Customer customer) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("customer", gson.toJsonTree(customer));

        MakeHttpPost post = new MakeHttpPost("editCustomer", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteCustomer(Customer customer) {

        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("customer", gson.toJsonTree(customer));

        MakeHttpPost post = new MakeHttpPost("deleteCustomer", json.getData(), apiKey, WebControllers.isicashier);

        try {
            String response = post.post();

            return response.trim().equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    //ISIORDER

    public ArrayList<IsiorderAccount> getAccounts() {
        ArrayList<IsiorderAccount> accounts = new ArrayList<>();
        try {

            HttpJson json = new HttpJson();
            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("isiorderUser", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            accounts = gson.fromJson(result, new TypeToken<ArrayList<IsiorderAccount>>() {
            }.getType());

        } catch (Exception ignored) {

        }
        return accounts;
    }

    public boolean editIsiorderAccount(IsiorderAccount account) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("account", gson.toJsonTree(account));

            MakeHttpPost post = new MakeHttpPost("editIsiorderAccount", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.contains("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean addIsiorderAccount(IsiorderAccount account) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("account", gson.toJsonTree(account));

            MakeHttpPost post = new MakeHttpPost("addIsiorderAccount", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.contains("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public IsiorderOrdersProductElement getOrderForTable(int table) {
        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", table);

            MakeHttpPost post = new MakeHttpPost("getOrderForTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, IsiorderOrdersProductElement.class);

        } catch (Exception ignored) {

        }

        return null;
    }

    public boolean cancelOrderGuest(int id) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);

            MakeHttpPost post = new MakeHttpPost("cancelOrderGuest", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.contains("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean sendDelivery(String jsona, String elements, int operator) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("json", jsona);
            json.addData("elements", elements);
            json.addData("operator", operator);

            MakeHttpPost post = new MakeHttpPost("sendDelivery", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.contains("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public ArrayList<CtzonOrder> getMyIsiDel() {

        ArrayList<CtzonOrder> missions = new ArrayList<>();

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getMyIsiDel", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            if (result.trim().equals("notActive")) {
                return missions;
            }

            missions = gson.fromJson(result, new TypeToken<ArrayList<CtzonOrder>>() {
            }.getType());

        } catch (Exception ignored) {

        }

        return missions;

    }

    public boolean confirmIsiDel(String id, boolean confirm, boolean isidel) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);
            json.addData("confirm", confirm);
            json.addData("isidel", isidel);

            MakeHttpPost post = new MakeHttpPost("confirmIsiDel", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean updateStatus(int id, int status) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);
            json.addData("status", status);
            MakeHttpPost post = new MakeHttpPost("updateStatusDelivery", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public void occupingTable(int id, int operator) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);
            json.addData("account", operator);
            MakeHttpPost post = new MakeHttpPost("occupingTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

        } catch (Exception ignored) {

        }
    }

    public void releaseTable(int id) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);

            MakeHttpPost post = new MakeHttpPost("releaseTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

        } catch (Exception ignored) {

        }

    }

    public boolean checkisiDel() {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            MakeHttpPost post = new MakeHttpPost("getMyIsiDel", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return !result.trim().equals("notActive");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean reopenOrder(int id) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);

            MakeHttpPost post = new MakeHttpPost("reopenOrder", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean updateElementAlreadySent(IsiorderElementOrder element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", element.id);
            json.addData("newName", element.new_name);
            json.addData("newPrice", element.new_price);

            MakeHttpPost post = new MakeHttpPost("changeElementAlreadySent", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<ThermalPrinter> getIsiOrderPrinter() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getPrinters", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<ThermalPrinter>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;

    }

    public CategoriesTableResponse getCategoriesTablesActive() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("tablesActive", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            JsonObject obj = JsonParser.parseString(result).getAsJsonObject();

            ArrayList<IsiorderCategoryAndTables> isiorderCategoryAndTables = gson.fromJson(obj.getAsJsonArray("categories"), new TypeToken<ArrayList<IsiorderCategoryAndTables>>() {
            }.getType());
            ArrayList<IsiorderInformationOrders> isiorderInformationOrders = gson.fromJson(obj.getAsJsonArray("informations"), new TypeToken<ArrayList<IsiorderInformationOrders>>() {
            }.getType());


            return new CategoriesTableResponse(isiorderInformationOrders, isiorderCategoryAndTables);

        } catch (Exception ignored) {

        }

        return null;


    }

    public ArrayList<IsiorderCategoryAndTables> getCategoriesTables() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("tables", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsiorderCategoryAndTables>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean canAccess(int id) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);

            MakeHttpPost post = new MakeHttpPost("canAccess", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public JsonObject IsiorderSendOrder(IsiorderOrdersProductElement isiorderOrdersProductElement, ArrayList<Integer> deleting, boolean stamp) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("order", gson.toJsonTree(isiorderOrdersProductElement));
            json.addData("deleting", gson.toJsonTree(deleting));
            json.addData("stamp", stamp);

            MakeHttpPost post = new MakeHttpPost("sendOrder", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, JsonObject.class);

        } catch (Exception ignored) {

        }

        return new JsonObject();
    }

    public boolean reprintOrder(int id) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);

            MakeHttpPost post = new MakeHttpPost("reprintOrder", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean printPrebuill(int id, boolean discount_auto, boolean romana, boolean all) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);
            json.addData("discount_auto", discount_auto);
            json.addData("romana", romana);
            json.addData("all", all);

            MakeHttpPost post = new MakeHttpPost("printPrebill", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean setRomanaPayedElement(int orderId, boolean stamp, int account_id, float discount, float total, int peopleSelected) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("order_id", orderId);
            json.addData("stamp", stamp);
            json.addData("account_id", account_id);
            json.addData("discount", discount);
            json.addData("total", total);
            json.addData("people", peopleSelected);

            MakeHttpPost post = new MakeHttpPost("setRomanaPayedElement", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean setPayedElement(ArrayList<Integer> ids, int orderId, boolean stamp, int account_id, float discount, float total) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", gson.toJsonTree(ids));
            json.addData("order_id", orderId);
            json.addData("stamp", stamp);
            json.addData("account_id", account_id);
            json.addData("discount", discount);
            json.addData("total", total);

            MakeHttpPost post = new MakeHttpPost("setPayedElements", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean setReadedMessages(int toId) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("to_id", toId);

            MakeHttpPost post = new MakeHttpPost("setReadedMessages", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<IsiorderChatAccounts> getAllMyMessages(int myId) {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("myId", myId);

            MakeHttpPost post = new MakeHttpPost("getAllMyMessages", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsiorderChatAccounts>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean deleteChat(int fromId, int toId) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("from_id", fromId);
            json.addData("to_id", toId);

            MakeHttpPost post = new MakeHttpPost("deleteChat", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean sendMessageToPrinter(int id, String text, int operator) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", id);
            json.addData("text", text);
            json.addData("operator", operator);

            MakeHttpPost post = new MakeHttpPost("sendMessageToPrinter", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public ArrayList<IsiorderOrdersProductElement> getAllOrderToday(int myId) {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("myId", myId);

            MakeHttpPost post = new MakeHttpPost("getAllOrderToday", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsiorderOrdersProductElement>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public ArrayList<IsiorderOrdersProductElement> getOrderFromTo(Date start, Date end) {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("start", start.getTime());
            json.addData("end", end.getTime());

            MakeHttpPost post = new MakeHttpPost("getOrderFromTo", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsiorderOrdersProductElement>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean changeCoperti(int orderId, int coperti) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("order_id", orderId);
            json.addData("coperti", coperti);

            MakeHttpPost post = new MakeHttpPost("changeCoperti", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean moveTable(int order, int table) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("order", order);
            json.addData("table", table);

            MakeHttpPost post = new MakeHttpPost("moveTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean addSconto(int order, double sconto) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", order);
            json.addData("sconto", sconto);

            MakeHttpPost post = new MakeHttpPost("addSconto", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean printExit(int order, int exit) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", order);
            json.addData("whatExit", exit);

            MakeHttpPost post = new MakeHttpPost("printExit", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean cleanTable(int account_id, int order, boolean stamp, float discount, float total, String ctzonCard) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("account_id", account_id);
            json.addData("id", order);
            json.addData("stamp", stamp);
            json.addData("discount", discount);
            json.addData("total", total);
            json.addData("ctzonCard", ctzonCard);


            MakeHttpPost post = new MakeHttpPost("cleanTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("tableCleaned");

        } catch (Exception ignored) {

        }

        return false;

    }

    public IsiorderGeneralInfo getIsiorderGeneralInfo() {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getIsiorderGeneralInfo", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, IsiorderGeneralInfo.class);

        } catch (Exception ignored) {

        }

        return null;
    }

    public boolean getChatService() {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getChatService", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("activated");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean addMessageChat(int account_id, int friend_id, String message) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", account_id);
            json.addData("friendId", friend_id);
            json.addData("txt", message);

            MakeHttpPost post = new MakeHttpPost("addMessageChat", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("arrived");

        } catch (Exception ignored) {

        }

        return false;

    }

    public List<IsiorderChat> getChatMessage(int myId, int friend_id) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("myId", myId);
            json.addData("friendId", friend_id);

            MakeHttpPost post = new MakeHttpPost("getChatMessage", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsiorderChat>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return new ArrayList<>();
    }

    public boolean isiorderAddTable(IsiorderTableElement element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("table", element);

            MakeHttpPost post = new MakeHttpPost("isiorderAddTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderEditTable(IsiorderTableElement element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("table", element);

            MakeHttpPost post = new MakeHttpPost("isiorderEditTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderAddCategoryTable(IsiorderTableCategory element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("category", element);

            MakeHttpPost post = new MakeHttpPost("isiorderAddCategoryTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderEditCategoryTable(IsiorderTableCategory element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("category", element);

            MakeHttpPost post = new MakeHttpPost("isiorderEditCategoryTable", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderAddNote(IsiorderNote element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("note", element);

            MakeHttpPost post = new MakeHttpPost("isiorderAddNote", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean isiorderEditNote(IsiorderNote element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("note", element);

            MakeHttpPost post = new MakeHttpPost("isiorderEditNote", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<IsiorderNote> isiorderGetNotes() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("isiorderGetNotes", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsiorderNote>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean addThermalPrinter(ThermalPrinter printer, List<ThermalPrinterCategory> thermalPrinterCategories, List<ThermalPrinterSubcategory> thermalPrinterSubcategories) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("printer", gson.toJsonTree(printer));
            json.addData("categories", gson.toJsonTree(thermalPrinterCategories));
            json.addData("subcategories", gson.toJsonTree(thermalPrinterSubcategories));

            MakeHttpPost post = new MakeHttpPost("addThermalPrinter", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean editThermalPrinter(ThermalPrinter printer, List<ThermalPrinterCategory> thermalPrinterCategories, List<ThermalPrinterSubcategory> thermalPrinterSubcategories) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("printer", gson.toJsonTree(printer));
            json.addData("categories", gson.toJsonTree(thermalPrinterCategories));
            json.addData("subcategories", gson.toJsonTree(thermalPrinterSubcategories));

            MakeHttpPost post = new MakeHttpPost("editThermalPrinter", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<ThermalPrinterAndCategories> getIsiOrderPrinterAndCategories() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getThermalPrintersAndCategories", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<ThermalPrinterAndCategories>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;

    }

    public ArrayList<Integer> testThermalPrinter(ThermalPrinter printer) {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("printer", gson.toJsonTree(printer));

            MakeHttpPost post = new MakeHttpPost("testThermalPrinter", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<ThermalPrinterAndCategories>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;

    }

    public void printCarico(ArrayList<String> toPrint, int tot) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("toPrint", gson.toJsonTree(toPrint));
            json.addData("tot", tot);
            MakeHttpPost post = new MakeHttpPost("printCarico", json.getData(), apiKey, WebControllers.isiorder);

            post.post();

        } catch (Exception ignored) {

        }
    }

    public String transformIsiorderPrivilege(int privilege) {
        switch (privilege) {
            case 1:
                return "Admin";
            case 2:
                return "Cassa";
            default:
                return "cameriere";
        }
    }

    public boolean editIsiorderGeneralInfo(IsiorderGeneralInfo info) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("info", gson.toJsonTree(info));

            MakeHttpPost post = new MakeHttpPost("editIsiorderGeneralInfo", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean changeIsiorderPassword(int account, String password) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("password", password);
            json.addData("account", account);

            MakeHttpPost post = new MakeHttpPost("changeIsiorderPassword", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<IsiorderGuestOrder> getIsiorderGuestOrder() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getAllOrdersGuest", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsiorderGuestOrder>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean setIsiorderOrderServed(IsiorderOrdersProductElement id) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("isiorderorder", gson.toJsonTree(id));

            MakeHttpPost post = new MakeHttpPost("setIsiorderOrderServed", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean updateTableMassive(List<IsiorderTableElement> element) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("tables", element);

            MakeHttpPost post = new MakeHttpPost("updateTableMassive", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean addPrinterRule(String description, int printerId, List<IsiorderTableCategory> isiorderTableCategories, List<Category> categories) {
        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("description", description);
        json.addData("thermal_id", printerId);
        json.addData("table_categories", gson.toJsonTree(isiorderTableCategories));
        json.addData("element_category", gson.toJsonTree(categories));

        MakeHttpPost post = new MakeHttpPost("addPrinterRule", json.getData(), apiKey, WebControllers.isiorder);

        try {
            String response = post.post();

            return response.equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<IsiorderPrinterRulesAndCategories> getPrinterRules() {
        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);

        MakeHttpPost post = new MakeHttpPost("getPrinterRules", json.getData(), apiKey, WebControllers.isiorder);

        try {
            String response = post.post();

            return gson.fromJson(response, new TypeToken<ArrayList<IsiorderPrinterRulesAndCategories>>() {
            }.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean editActivePrinterRule(int id, boolean active) {
        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", id);
        json.addData("active", active);

        MakeHttpPost post = new MakeHttpPost("editActivePrinterRule", json.getData(), apiKey, WebControllers.isiorder);

        try {
            String response = post.post();

            return response.equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean editOrderNote(int id, String note) {
        HttpJson json = new HttpJson();

        json.addData("commercial", this.commercial.local_id);
        json.addData("id", id);
        json.addData("note", note);

        MakeHttpPost post = new MakeHttpPost("editOrderNote", json.getData(), apiKey, WebControllers.isiorder);

        try {
            String response = post.post();

            return response.equals("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<DevicesAuthorization> listOfDeviceAuth() {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getClientDevices", json.getData(), "", WebControllers.isiorder);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<List<DevicesAuthorization>>() {
            }.getType());

        } catch (Exception ignored) {

        }

        return null;

    }

    public boolean deleteCron() {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("deleteCronDevices", json.getData(), "", WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public boolean changeDeviceActivation(int deviceId, boolean active) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("id", deviceId);
            json.addData("active", active ? 1 : 0);

            MakeHttpPost post = new MakeHttpPost("changeDeviceActivation", json.getData(), "", WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;

    }

    public List<Ingredients> getProductIngredients(Product p) {

        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("product", gson.toJsonTree(p));

            MakeHttpPost post = new MakeHttpPost("getProductIngredients", json.getData(), "", WebControllers.isiorder);

            String result = post.post();
            return gson.fromJson(result, new TypeToken<List<Ingredients>>() {
            }.getType());

        } catch (Exception ignored) {

        }

        return null;

    }

    //ISIMAGA

    public ArrayList<ProductForniture> isimagaGetProductForniture() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getProductForniture", json.getData(), apiKey, WebControllers.isimaga);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<ProductForniture>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public String transformIsimagaUnity(int unity) {
        switch (unity) {
            case 0:
                return "Litri";
            case 1:
                return "Grammi";
            default:
                return "Unità";
        }
    }

    public boolean editProductForniture(ProductForniture f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("product", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("editProductForniture", json.getData(), apiKey, WebControllers.isimaga);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean addIsimagaProductMovement(IsimagaPorductMovement movement) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("movement", gson.toJsonTree(movement));

            MakeHttpPost post = new MakeHttpPost("addIsimagaProductMovement", json.getData(), apiKey, WebControllers.isimaga);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<IsimagaPorductMovement> getIsimagaProductMovements(int product_forniture_id) {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("product_forniture_id", product_forniture_id);

            MakeHttpPost post = new MakeHttpPost("getIsimagaProductMovements", json.getData(), apiKey, WebControllers.isimaga);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsimagaPorductMovement>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;

    }

    public boolean addProductForniture(ProductForniture f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("product", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("addProductForniture", json.getData(), apiKey, WebControllers.isimaga);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean createListino(IsiorderListini listino){
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("listino", gson.toJsonTree(listino));

            MakeHttpPost post = new MakeHttpPost("createListino", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean editListino(IsiorderListini listino){
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("listino", gson.toJsonTree(listino));

            MakeHttpPost post = new MakeHttpPost("editListino", json.getData(), apiKey, WebControllers.isiorder);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    //ISICHAIN

    public ArrayList<Forniture> getForniture() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getForniture", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<Forniture>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean editForniture(Forniture f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("forniture", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("editForniture", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean addForniture(Forniture f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("forniture", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("addForniture", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<OrdersAndForniture> getOrderToForniture() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getOrderToForniture", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<OrdersAndForniture>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean addOrderToForniture(OrderToForniture f, List<OrderToFornitureElement> elements) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("order", gson.toJsonTree(f));
            json.addData("elements", gson.toJsonTree(elements));

            MakeHttpPost post = new MakeHttpPost("addOrderToForniture", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean editOrderToForniture(OrderToForniture f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("order", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("editOrderToForniture", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean editOrderToFornitureElements(List<OrderToFornitureElement> elements) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("elements", gson.toJsonTree(elements));

            MakeHttpPost post = new MakeHttpPost("editOrderToFornitureElements", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean acceptOrderForniture(OrdersAndForniture f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("order", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("acceptOrderForniture", json.getData(), apiKey, WebControllers.isichain);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    //ISISHOP

    public List<CommercialCategoryAndMy> getCommercialCategories() {
        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getCommercialCategories", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<CommercialCategoryAndMy>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;

    }

    public boolean editCommercialCategories(List<MyCommercialCategory> categories) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("categories", gson.toJsonTree(categories));

            MakeHttpPost post = new MakeHttpPost("editCommercialCategories", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<ExtraordinaryClosing> getExtraordinaryClosing() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getExtraordinaryClosing", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<ExtraordinaryClosing>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean editExtraordinaryClosing(ExtraordinaryClosing f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("closing", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("editExtraordinaryClosing", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public boolean addExtraordinaryClosing(ExtraordinaryClosing f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("closing", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("addExtraordinaryClosing", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<OpeningHours> getHopeningHours() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getHopeningHours", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<OpeningHours>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean editHopeningHours(OpeningHours f) {
        try {

            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("hours", gson.toJsonTree(f));

            MakeHttpPost post = new MakeHttpPost("editHopeningHours", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return result.trim().equals("ok");

        } catch (Exception ignored) {

        }

        return false;
    }

    public ArrayList<IsicoinMovement> getIsicoinMovement() {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);

            MakeHttpPost post = new MakeHttpPost("getIsicoinMovement", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return gson.fromJson(result, new TypeToken<ArrayList<IsicoinMovement>>() {
            }.getType());
        } catch (Exception ignored) {

        }

        return null;


    }

    public boolean addIsicoinMovement(IsicoinMovement isicoinMovement) {

        try {
            HttpJson json = new HttpJson();

            json.addData("commercial", this.commercial.local_id);
            json.addData("movement", gson.toJsonTree(isicoinMovement));

            MakeHttpPost post = new MakeHttpPost("addIsicoinMovement", json.getData(), apiKey, WebControllers.isishop);

            String result = post.post();

            return result.trim().equals("ok");
        } catch (Exception ignored) {

        }

        return false;


    }

}


