package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class InspirationModel {
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;
    @SerializedName("updated_date")
    String updated_date;
    @SerializedName("created_date")
    String created_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
}
