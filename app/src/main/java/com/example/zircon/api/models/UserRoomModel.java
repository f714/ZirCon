package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class UserRoomModel {
    @SerializedName("user_id")

    private String user_id;
    @SerializedName("room_id")
    private String room_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }
}
