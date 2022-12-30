package com.example.zircon.api;

import com.example.zircon.api.models.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Anza/signup.php")
    Call<List<User>> signupUser(@Field("name") String name, @Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("Anza/login.php")
    Call<List<User>> loginUser( @Field("email") String email, @Field("password") String password);
//
//    @FormUrlEncoded
//    @POST("Anza/add_personal_room.php")
//    Call<List<RoomModel>> createRoom(@Field("title") String title, @Field("description") String description,
//                                     @Field("start_time") String start_time,@Field("end_time") String end_time
//            ,@Field("type") String type,@Field("number_of_participants") String number_of_participants,@Field("duration") String duration,@Field("start_date") String start_date,@Field("end_date") String end_date,@Field("status") String status,
//                                   @Field("recitation_target") String recitation_target,
//                                     @Field("id") String id);

    @FormUrlEncoded
    @POST("Anza/add_zikr.php")
    Call<List<ZikrModel>> addZikr(@Field("title") String title, @Field("description") String description, @Field("narrator") String narrator, @Field("number_of_ayat") String number_of_ayat, @Field("counting") String counting,@Field("status") String status, @Field("id") String room_id);

    @FormUrlEncoded
    @POST("Anza/load_room_in_progress_rooms.php")
    Call<List<HomeInProgressModel>> homeInProgress(@Field("type") String type, @Field("owner_id") String owner_id);

    @FormUrlEncoded
    @POST("Anza/load_my_rooms.php")
    Call<List<LoadMyRoomsModel>> loadMyRooms(@Field("type") String type, @Field("owner_id") String owner_id);

    @FormUrlEncoded
    @POST("Anza/load_my_room_by_title.php")
    Call<List<LoadMyRoomsModel>> loadMyRoomByTitle(@Field("title") String title);

    @FormUrlEncoded
    @POST("Anza/load_home_today_in_progress_rooms.php")
    Call<List<LoadHomeTodayInProgressModel>> homeTodayInProgress(@Field("type") String type, @Field("owner_id") String owner_id);

    @FormUrlEncoded
    @POST("Anza/add_personal_room.php")
    Call<RoomModel> createRoomCom(@Field("title") String title, @Field("description") String description,@Field("start_time") String start_time,@Field("end_time") String end_time,@Field("type") String type,@Field("number_of_participants") String number_of_participants,@Field("duration") String duration,@Field("start_date") String start_date,@Field("end_date") String end_date,@Field("status") String status,@Field("recitation_target") String recitation_target,@Field("id") String id);

    @FormUrlEncoded
    @POST("Anza/add_personal_room.php")
    Call<RoomModel> createRoom(@Field("title") String title, @Field("description") String description,@Field("start_time") String start_time,@Field("end_time") String end_time,@Field("type") String type,@Field("number_of_participants") String number_of_participants,@Field("duration") String duration,@Field("start_date") String start_date,@Field("end_date") String end_date,@Field("status") String status,@Field("recitation_target") String recitation_target,@Field("id") String id);


    @FormUrlEncoded
    @POST("Anza/add_recurrence.php")
    Call<RecurrenceModel> recurrence(@Field("room_id") String room_id,@Field("zikr_count") String zikr_count,@Field("complete_count") String complete_count,@Field("recurrence_day") String recurrence_day,@Field("recurrence_date") String recurrence_date);

    @GET("Anza/get_Inspirations.php")
    Call<List<InspirationModel>> getInspirations();

    @GET("Anza/get_verses.php")
    Call<List<VersesModel>> getVerses();


    @GET("Anza/get_Diseases.php")
    Call<List<DiseasesModel>> getDiseases();

    @FormUrlEncoded
    @POST("Anza/get_profile.php")
    Call<List<ProfileModel>> getUserDetails(@Field("email") String email);


    @FormUrlEncoded
    @POST("Anza/update_profile.php")
    Call<List<UpdateChangesModel>> updateChanges(@Field("email") String email, @Field("name")String name,@Field("password") String password);
    @FormUrlEncoded
    @POST("Anza/save_user_room.php")
    Call<List<Object>> addUserRoomRecord(@Field("room_id") int roomId, @Field("user_id") String userid);
    @GET("Anza/get_user_room.php")
    Call<List<UserRoomModel>> getUserRoomRecord();
}
