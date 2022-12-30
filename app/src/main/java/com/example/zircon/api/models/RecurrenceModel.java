package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class RecurrenceModel {


    @SerializedName("room_id")
    String room_id;
    @SerializedName("zikr_count")
    int zikr_count;
    @SerializedName("complete_count")
    String complete_count;
    @SerializedName("recurrence_day")
    int recurrence_day;
    @SerializedName("recurrence_date")
    String recurrence_date;

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public int getZikr_count() {
        return zikr_count;
    }

    public void setZikr_count(int zikr_count) {
        this.zikr_count = zikr_count;
    }

    public String getComplete_count() {
        return complete_count;
    }

    public void setComplete_count(String complete_count) {
        this.complete_count = complete_count;
    }

    public int getRecurrence_day() {
        return recurrence_day;
    }

    public void setRecurrence_day(int recurrence_day) {
        this.recurrence_day = recurrence_day;
    }

    public String getRecurrence_date() {
        return recurrence_date;
    }

    public void setRecurrence_date(String recurrence_date) {
        this.recurrence_date = recurrence_date;
    }
}
