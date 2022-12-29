package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class UpdateChangesModel {


    @SerializedName("update_status")
    String update_status;

    public String getUpdate_status() {
        return update_status;
    }

    public void setUpdate_status(String update_status) {
        this.update_status = update_status;
    }
}
