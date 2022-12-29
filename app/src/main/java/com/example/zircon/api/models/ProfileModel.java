package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class ProfileModel {

    @SerializedName("name")
    String name;
    @SerializedName("id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
