package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class LoadMyRoomsModel {

    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;

    @SerializedName("status")
    String status;
    @SerializedName("zikr_narrator")
    String narrator;

    @SerializedName("zikr_counting")
    String zikr_counting;
    @SerializedName("recitation_completed")
    String recitation_completed;


    @SerializedName("start_date")
    String start_date;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }


    public String getZikr_counting() {
        return zikr_counting;
    }

    public void setZikr_counting(String zikr_counting) {
        this.zikr_counting = zikr_counting;
    }

    public String getRecitation_completed() {
        return recitation_completed;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public void setRecitation_completed(String recitation_completed) {
        this.recitation_completed = recitation_completed;
    }
}
