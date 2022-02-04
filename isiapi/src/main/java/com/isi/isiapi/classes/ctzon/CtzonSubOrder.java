package com.isi.isiapi.classes.ctzon;

import java.util.ArrayList;
import java.util.Date;

public class CtzonSubOrder {

    public int Id;
    public String CommercialLocalId;
    public Date PrevisionTimeTrue;
    public boolean IsidelWith;
    public int CityzonOrderId;
    public int DeliveryConfirm;
    public int VendorConfirm;
    public ArrayList<CtzonSuborderStatus> CityzonSuborderStatuses;
    public ArrayList<CtzonElement> CityzonElements;

}