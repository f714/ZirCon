package com.example.zircon.api.models;

import com.google.gson.annotations.SerializedName;

public class RoomModel {

    @SerializedName("response")
    String response;
    @SerializedName("room_id")
    String roomid;

    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
//   @SerializedName("start_time")
//    String start_time;
//    @SerializedName("end_time")
//    String end_time;
    @SerializedName("type")
    String type;
    @SerializedName("number_of_participants")
    String number_of_participants;
    @SerializedName("duration")
    String duration;
    @SerializedName("start_date")
    String start_date;
    @SerializedName("end_date")
    String end_date;
 @SerializedName("recitation_target")
    String recitation_target;
    @SerializedName("status")
    String status;
    @SerializedName("id")
    String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//   public String getStart_time() {
//      return start_time;
//    }

//    public void setStart_time(String start_time) {
//       this.start_time = start_time;
//    }

//    public String getEnd_time() {
//        return end_time;
//    }

//    public void setEnd_time(String end_time) {
//        this.end_time = end_time;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber_of_participants() {
        return number_of_participants;
    }

    public void setNumber_of_participants(String number_of_participants) {
        this.number_of_participants = number_of_participants;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

   public String getRecitation_target() {
       return recitation_target;
   }

   public void setRecitation_target(String recitation_target) {
        this.recitation_target = recitation_target;
   }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }
}
