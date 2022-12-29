package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.LoadMyRoomsModel;
import com.example.zircon.rcvadapters.MyRoomsRecyclerviewAdapter;

import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class All_Community_Rooms extends AppCompatActivity implements MyRoomsRecyclerviewAdapter.ItemClickListener {

    ApiInterface apiInterface;
    RecyclerView communityroomRcv;
    MyRoomsRecyclerviewAdapter adapter;
    List<LoadMyRoomsModel> allRooms;

    TextView viewAllTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_community_rooms);

        String userId = getIntent().getStringExtra("id");

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        communityroomRcv = (RecyclerView) findViewById(R.id.communityroomRcv);

        communityroomRcv.setLayoutManager(new GridLayoutManager(this, 2));

        Call<List<LoadMyRoomsModel>> myRoomCall = apiInterface.loadMyRooms("community", userId);
        myRoomCall.enqueue(new Callback<List<LoadMyRoomsModel>>() {
            @Override
            public void onResponse(Call<List<LoadMyRoomsModel>> call, Response<List<LoadMyRoomsModel>> response) {
                if(response.isSuccessful()) {
                    allRooms = response.body();

                    for (LoadMyRoomsModel myRoom: allRooms) {
                        Log.d("TAG", "onResponse:"+myRoom.getNarrator());
//                        Toast.makeText(My_Rooms.this, myRoom.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                    adapter = new MyRoomsRecyclerviewAdapter(All_Community_Rooms.this, allRooms);
                    adapter.setClickListener(All_Community_Rooms.this);
                    communityroomRcv.setAdapter(adapter);

                } else {
                    Toast.makeText( All_Community_Rooms.this, "Error in loading rooms", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<LoadMyRoomsModel>> call, Throwable t) {
                Toast.makeText(All_Community_Rooms.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d("khadija", "onItemClick: "+allRooms.get(position).getNarrator());
        Paper.init(All_Community_Rooms.this);
        Paper.book().write(
                "img",
                String.valueOf(allRooms.get(position).getNarrator())
        );
        Toast.makeText(All_Community_Rooms.this, allRooms.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        Intent personalIntent= new Intent(All_Community_Rooms.this,PersonalRoom.class);
        personalIntent.putExtra("title",allRooms.get(position).getTitle());
        personalIntent.putExtra("zikr_counting",allRooms.get(position).getZikr_counting());
        personalIntent.putExtra("recitation_completed",allRooms.get(position).getRecitation_completed());
        personalIntent.putExtra("start_date",allRooms.get(position).getStart_date());
        personalIntent.putExtra("status",allRooms.get(position).getStatus());


        startActivity(personalIntent);
    }
}