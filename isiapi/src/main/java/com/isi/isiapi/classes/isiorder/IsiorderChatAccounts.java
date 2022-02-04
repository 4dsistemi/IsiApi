package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiorderChatAccounts extends LastModifiedTables {

    IsiorderChat chat;

    IsiorderAccount from;

    IsiorderAccount to;
}
