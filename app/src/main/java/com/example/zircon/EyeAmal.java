package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.DiseasesModel;
import com.example.zircon.api.models.VersesModel;
import com.example.zircon.rcvadapters.DailyVersesRecyclerViewAdapter;
import com.example.zircon.rcvadapters.DiseasesRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EyeAmal extends AppCompatActivity {
    ApiInterface apiInterface;
    RecyclerView DiseasesRcv;
    DiseasesRecyclerViewAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_amal);

        DiseasesRcv = (RecyclerView)findViewById(R.id.DiseasesRcv);
        DiseasesRcv.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<DiseasesModel>> diseasesCall = apiInterface.getDiseases();
        diseasesCall.enqueue(new Callback<List<DiseasesModel>>() {
            @Override
            public void onResponse(Call<List<DiseasesModel>> call, Response<List<DiseasesModel>> response) {
                if(response.isSuccessful()){
                    List<DiseasesModel> Diseaseslist = response.body();
                    adapter = new DiseasesRecyclerViewAdapter(EyeAmal.this, Diseaseslist);
                    DiseasesRcv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<DiseasesModel>> call, Throwable t) {
                Toast.makeText(EyeAmal.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }




}
