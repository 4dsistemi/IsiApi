package com.isi.isiapi.general.classes.ctzon;

import java.util.ArrayList;
import java.util.Date;

public class CtzonSubOrder {

    public int Id;
    public String CommercialLocalId;
    public Date PrevisionTimeTrue;
    public boolean IsidelWith;
    public int CityzonOrderId;
    public boolean DeliveryConfirm;
    public boolean VendorConfirm;
    ArrayList<CtzonSuborderStatus> CityzonSuborderStatuses;
    ArrayList<CtzonElement> CityzonElements;

}
