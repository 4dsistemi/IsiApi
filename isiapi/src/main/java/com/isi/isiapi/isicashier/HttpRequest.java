package com.isi.isiapi.isicashier;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.BillProduct;
import com.isi.isiapi.general.classes.Category;
import com.isi.isiapi.general.classes.Customer;
import com.isi.isiapi.general.classes.Department;
import com.isi.isiapi.general.classes.Discount;
import com.isi.isiapi.general.classes.Fattura;
import com.isi.isiapi.general.classes.InformationAboutCommercial;
import com.isi.isiapi.general.classes.Operator;
import com.isi.isiapi.general.classes.Printer;
import com.isi.isiapi.general.classes.Product;
import com.isi.isiapi.general.classes.Report;

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


    public ArrayList<Operator> getOperators(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getOperators", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Operator>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addDepartment(String serial, int dep_number, String dep_code, Integer product_id){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("dep_number", dep_number);
        json.addData("dep_code", dep_code);
        json.addData("product_id", product_id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addDepartment", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modifyDepartment(String serial, int dep_id, String dep_number, String dep_code, Integer product_id){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("dep_id", dep_id);
        json.addData("dep_number", dep_number);
        json.addData("dep_code", dep_code);
        json.addData("product_id", product_id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "modifyDepartment", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Department> getDepartment(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getDepartments", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Department>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addCategory(String serial, String name, Integer color){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("name", name);
        json.addData("color", color);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addCategory", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<Category> getCategories(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getCategories", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Category>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<Customer> getCustomers(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getCustomers", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Customer>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addCustomer(String serial, Customer customer){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("name", customer.getName());
        json.addData("surname", customer.getSurname());
        json.addData("iva", customer.getIva());
        json.addData("email", customer.getEmail());
        json.addData("address", customer.getAddress());
        json.addData("city", customer.getCity());
        json.addData("province", customer.getProvince());
        json.addData("zip", customer.getZip());
        json.addData("country", customer.getCountry());
        json.addData("phone", customer.getPhone());
        json.addData("pec", customer.getPec());
        json.addData("ae_code", customer.getAeCode());
        json.addData("society", customer.getSociety());
        json.addData("fiscal", customer.getFiscal());
        json.addData("birthday" , customer.getBirthday());
        json.addData("doc_type", customer.getDocType());
        json.addData("doc_serial" , customer.getDocSerial());
        json.addData("doc_release" , customer.getDocRelease());
        json.addData("doc_expire", customer.getDocExpire());
        json.addData("birthplace" , customer.getBirthplace());

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addCustomer", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modifyCustomer(Customer customer){

        HttpJson json = new HttpJson();
        json.addData("id", customer.getId());
        json.addData("name", customer.getName());
        json.addData("surname", customer.getSurname());
        json.addData("iva", customer.getIva());
        json.addData("email", customer.getEmail());
        json.addData("address", customer.getAddress());
        json.addData("city", customer.getCity());
        json.addData("province", customer.getProvince());
        json.addData("zip", customer.getZip());
        json.addData("country", customer.getCountry());
        json.addData("phone", customer.getPhone());
        json.addData("pec", customer.getPec());
        json.addData("ae_code", customer.getAeCode());
        json.addData("society", customer.getSociety());
        json.addData("fiscal", customer.getFiscal());
        json.addData("birthday" , customer.getBirthday());
        json.addData("doc_type" , customer.getDocType());
        json.addData("doc_serial" , customer.getDocSerial());
        json.addData("doc_release" , customer.getDocRelease());
        json.addData("doc_expire" , customer.getDocExpire());
        json.addData("birthplace" , customer.getBirthplace());

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "modifyCustomer", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<Product> getProducts(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getProducts", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Product>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<Printer> getPrinters(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getPrinters", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Printer>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addPrinter(String serial, Printer printer){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("name", printer.name);
        json.addData("ip", printer.ip);
        json.addData("is_pref", printer.isPref);
        json.addData("type", printer.type);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addPrinter", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean editPrinter(Printer printer){

        HttpJson json = new HttpJson();
        json.addData("id", printer.id);
        json.addData("name", printer.name);
        json.addData("type", printer.type);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "editPrinter", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteProduct(String serial, int id){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "deleteProduct", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addProduct(String serial, Product product){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("name", product.name);
        json.addData("price", product.price);
        json.addData("color", product.color);
        json.addData("category_id", product.category_id);
        json.addData("department_id", product.department_id);
        json.addData("barcode", product.barcode);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addProduct", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modifyProduct(Product product){

        HttpJson json = new HttpJson();
        json.addData("id", product.id);
        json.addData("name", product.name);
        json.addData("price", product.price);
        json.addData("color", product.color);
        json.addData("category_id", product.category_id);
        json.addData("department_id", product.department_id);
        json.addData("barcode", product.barcode);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "updateProduct", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean deleteCustomer(String serial, int id){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "deleteCustomer", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean insertRefreshToken(String serial, String token){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("token", token);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "insertRefreshToken", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public String getGybToken(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getGybToken", json.getData(), apiKey, debug);

        try {
            return post.execute().get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    public boolean deleteGybToken(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "deleteGybToken", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public InformationAboutCommercial getInfoAboutMe(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getInfoAboutMe", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, InformationAboutCommercial.class);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;


    }

    public ArrayList<Report> getReport(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getReport", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Report>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<Report> getReportFromId(String serial, int operatorId){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("operator", operatorId);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getReportFromId", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Report>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Deprecated
    public boolean addBill(String serial, Discount discount, int operator, ArrayList<BillProduct> bill, String paymentType){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("discount_valor", (discount != null) ? discount.getValor() : 0);
        json.addData("discount_type", (discount != null) ? (discount.getType() == Discount.DISCOUNT_TYPE.CASH) ? 0 : 1 : 0);
        json.addData("operator", operator);
        json.addData("elements", new Gson().toJsonTree(bill));
        json.addData("payment_type", paymentType);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addBill", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    @Deprecated
    public boolean addBill(String serial, Discount discount, int operator, ArrayList<BillProduct> bill, String paymentType, float total){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("discount_valor", (discount != null) ? discount.getValor() : 0);
        json.addData("discount_type", (discount != null) ? (discount.getType() == Discount.DISCOUNT_TYPE.CASH) ? 0 : 1 : 0);
        json.addData("operator", operator);
        json.addData("elements", new Gson().toJsonTree(bill));
        json.addData("payment_type", paymentType);
        json.addData("total", total);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addBillWthTotal", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addBill(String serial, Discount discount, int operator, ArrayList<BillProduct> bill, String paymentType, float total, String card){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("discount_valor", (discount != null) ? discount.getValor() : 0);
        json.addData("discount_type", (discount != null) ? (discount.getType() == Discount.DISCOUNT_TYPE.CASH) ? 0 : 1 : 0);
        json.addData("operator", operator);
        json.addData("elements", new Gson().toJsonTree(bill));
        json.addData("payment_type", paymentType);
        json.addData("total", total);
        json.addData("card", card);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addBillWtithTotalAndCard", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<Fattura> getFatture(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "getFatture", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Fattura>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

    public boolean deleteFattura(int id){
        HttpJson json = new HttpJson();
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "deleteFattura", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateFatturaStatus(int id, int status, String date){
        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("status", status);
        json.addData("date", date);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "updateFatturaStatus", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addFattura(String serial, Discount discount, int operator, ArrayList<BillProduct> bill, String paymentType, String recoverCode, String customer){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("discount_valor", (discount != null) ? discount.getValor() : 0);
        json.addData("discount_type", (discount != null) ? (discount.getType() == Discount.DISCOUNT_TYPE.CASH) ? 0 : 1 : 0);
        json.addData("operator", operator);
        json.addData("elements", new Gson().toJsonTree(bill));
        json.addData("payment_type", paymentType);
        json.addData("recover_code", recoverCode);
        json.addData("customer", customer);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addFattura", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


        return false;

    }

    public boolean addStorno(String serial, String date, String reparto, int closeNum, int docNum, float total){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("total", total);
        json.addData("doc_num", docNum);
        json.addData("close_num", closeNum);
        json.addData("reparto", reparto);
        json.addData("data", date);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISICASHIER, "addStorno", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


        return false;

    }

}


