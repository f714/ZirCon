package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class DiseasesModel {


    @SerializedName("id")
    String id;

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

    @SerializedName("title")
    String title;
    @SerializedName("verses")
    String verses;
    @SerializedName("translation")
    String translation;
    @SerializedName("updated_date")
    String updated_date;
    @SerializedName("created_date")
    String created_date;


}
