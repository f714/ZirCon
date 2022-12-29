package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class ProfileModel {

    @SerializedName("name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
