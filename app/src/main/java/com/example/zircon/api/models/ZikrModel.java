package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class ZikrModel {

    @SerializedName("response")
    String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
