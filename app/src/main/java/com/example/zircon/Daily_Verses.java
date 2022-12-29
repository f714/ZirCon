package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.InspirationModel;
import com.example.zircon.api.models.VersesModel;
import com.example.zircon.rcvadapters.DailyVersesRecyclerViewAdapter;
import com.example.zircon.rcvadapters.InspirationsRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Daily_Verses extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView Daily_VersesRcv;
    DailyVersesRecyclerViewAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_verses);
        Daily_VersesRcv = (RecyclerView)findViewById(R.id.Daily_VersesRcv);
        Daily_VersesRcv.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<VersesModel>> versesCall = apiInterface.getVerses();
        versesCall.enqueue(new Callback<List<VersesModel>>() {
            @Override
            public void onResponse(Call<List<VersesModel>> call, Response<List<VersesModel>> response) {
                if(response.isSuccessful()){
                    List<VersesModel> verseslist = response.body();
                    adapter = new DailyVersesRecyclerViewAdapter(Daily_Verses.this, verseslist);
                    Daily_VersesRcv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<VersesModel>> call, Throwable t) {
                Toast.makeText(Daily_Verses.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



    }
