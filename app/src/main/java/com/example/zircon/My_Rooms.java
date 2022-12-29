package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

public class My_Rooms extends AppCompatActivity implements MyRoomsRecyclerviewAdapter.ItemClickListener {

    ApiInterface apiInterface;
    RecyclerView roomRcv;
    MyRoomsRecyclerviewAdapter adapter;
    List<LoadMyRoomsModel> allRooms;

    TextView viewAllTv;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rooms);

        userId = getIntent().getStringExtra("id");
//        Toast.makeText(this, userId, Toast.LENGTH_SHORT).show();

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        roomRcv = (RecyclerView) findViewById(R.id.roomRcv);

        viewAllTv = (TextView) findViewById(R.id.viewAllTv);

        viewAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewallIntent= new Intent(My_Rooms.this,View_all.class);
                viewallIntent.putExtra("id", userId);
                startActivity(viewallIntent);
            }
        });

        roomRcv.setLayoutManager(new GridLayoutManager(this, 2));



        Call<List<LoadMyRoomsModel>> myRoomCall = apiInterface.loadMyRooms("individual", userId);
        myRoomCall.enqueue(new Callback<List<LoadMyRoomsModel>>() {
            @Override
            public void onResponse(Call<List<LoadMyRoomsModel>> call, Response<List<LoadMyRoomsModel>> response) {
                if(response.isSuccessful()) {
                    allRooms = response.body();

                    for (LoadMyRoomsModel myRoom: allRooms) {
//                        Toast.makeText(My_Rooms.this, myRoom.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                    adapter = new MyRoomsRecyclerviewAdapter(My_Rooms.this, allRooms);
                    adapter.setClickListener(My_Rooms.this);
                    roomRcv.setAdapter(adapter);

                } else {
                    Toast.makeText(My_Rooms.this, "Error in loading rooms", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<LoadMyRoomsModel>> call, Throwable t) {
                Toast.makeText(My_Rooms.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public void onItemClick(View view, int position) {
        Paper.init(My_Rooms.this);
        Paper.book().write(
                "img",
                String.valueOf(allRooms.get(position).getNarrator())
        );
        Toast.makeText(My_Rooms.this, allRooms.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        Intent personalIntent= new Intent(My_Rooms.this,PersonalRoom.class);
        personalIntent.putExtra("title",allRooms.get(position).getTitle());
        personalIntent.putExtra("id", userId);
       personalIntent.putExtra("start_date",allRooms.get(position).getStart_date());
       personalIntent.putExtra("status",allRooms.get(position).getStatus());

        personalIntent.putExtra("zikr_counting",allRooms.get(position).getZikr_counting());

        startActivity(personalIntent);
    }
}