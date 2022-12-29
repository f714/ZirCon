package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.InspirationModel;
import com.example.zircon.rcvadapters.InspirationsRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Favourite extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView inspirationRcv;
    InspirationsRecyclerViewAdapter adapter;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        inspirationRcv = (RecyclerView)findViewById(R.id.inspirationRcv);
        inspirationRcv.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<InspirationModel>> inspirationCall = apiInterface.getInspirations();

        inspirationCall.enqueue(new Callback<List<InspirationModel>>() {
            @Override
            public void onResponse(Call<List<InspirationModel>> call, Response<List<InspirationModel>> response) {
                if(response.isSuccessful()){
                    List<InspirationModel> inspirationlst = response.body();
                    adapter = new InspirationsRecyclerViewAdapter(Favourite.this, inspirationlst);
                    inspirationRcv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<InspirationModel>> call, Throwable t) {
                Toast.makeText(Favourite.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}