package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class ApplicationPrivileges {

    @SerializedName("Id")
    private int id;

    @SerializedName("ApplicationList")
    private ApplicationList applicationList;

    @SerializedName("AccountId")
    private int operator_list_id;

    public ApplicationPrivileges(ApplicationList applicationList, int operator_list_id) {
        this.applicationList = applicationList;
        this.operator_list_id = operator_list_id;
    }

    public int getId() {
        return id;
    }

    public ApplicationList getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(ApplicationList applicationList) {
        this.applicationList = applicationList;
    }

    public int getOperator_list_id() {
        return operator_list_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOperator_list_id(int operator_list_id) {
        this.operator_list_id = operator_list_id;
    }
}
