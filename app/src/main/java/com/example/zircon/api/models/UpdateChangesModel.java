package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class UpdateChangesModel {


    @SerializedName("name")
    String name;

    @SerializedName("email")
    String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
