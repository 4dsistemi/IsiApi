package com.isi.isiapi.general;

public class Service {

    public static String getService(CTZON_SERVICE service){

        switch (service){
            case ISIAPP:
                return "API/IsiApp/IsiAppApi.php";
            case ISIMAGA:
                return "API/IsiMaga/IsiMagaApi.php";
            case ISINOLO:
                return "API/IsiNolo/IsiNoloApi.php";
            case ISICHAIN:
                return "API/IsiChain/IsiChainApi.php";
            case ISICHECK:
                return "myisicheck/API/isicheckapi.php";
            case ISICASHIER:
                return "API/IsiCashier/IsiCashierApi.php";
            case ISIORDER:
                return "API/IsiOrder/IsiOrderApi.php";
        }

        return "API/IsiCashier/IsiCashierApi.php";

    }

}

