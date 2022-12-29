package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.ProfileModel;
import com.example.zircon.api.models.User;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {


    Button btn;
    String email;
    ApiInterface apiInterface;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email = getIntent().getStringExtra("email");
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Toast.makeText(getApplicationContext(), email + "testing email", Toast.LENGTH_LONG).show();
        btn = (Button) findViewById(R.id.editBtn);
        btn.setOnClickListener(view -> {
            System.out.println("Inside button click");

            Call<List<ProfileModel>> getDetails = apiInterface.getName(email);
            getDetails.enqueue(new Callback<List<ProfileModel>>() {
                @Override
                public void onResponse(Call<List<ProfileModel>> call, Response<List<ProfileModel>> response) {
                    List<ProfileModel> list = response.body();
                    String name = list.get(0).getName();
                    Intent intent = new Intent(Profile.this, Portfolio.class
                    );
                    intent.putExtra("email", email);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<List<ProfileModel>> call, Throwable t) {

                }
            });

        });


    }
}