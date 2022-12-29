package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class HomeInProgressModel {

    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("recitation_target")
    String recitation_target;
    @SerializedName("recitation_completed")
    String recitation_completed;

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

    public String getRecitation_target() {
        return recitation_target;
    }

    public void setRecitation_target(String recitation_target) {
        this.recitation_target = recitation_target;
    }

    public String getRecitation_completed() {
        return recitation_completed;
    }

    public void setRecitation_completed(String recitation_completed) {
        this.recitation_completed = recitation_completed;
    }
}
