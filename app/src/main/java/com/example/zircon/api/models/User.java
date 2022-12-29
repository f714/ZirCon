package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class User {


    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
