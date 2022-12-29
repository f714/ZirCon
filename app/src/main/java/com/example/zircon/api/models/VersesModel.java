package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class VersesModel {


    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("verses")
    String verses;
    @SerializedName("translation")
    String translation;
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

    public String getVerses() {
        return verses;
    }

    public void setVerses(String verses) {
        this.verses = verses;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
}
