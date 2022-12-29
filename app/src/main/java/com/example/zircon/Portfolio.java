package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.UpdateChangesModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Portfolio extends AppCompatActivity {
    ApiInterface apiInterface;
    private Button saveChangesBtn;
    private TextInputLayout emailTIL, nameTIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        EditText editTextName = findViewById(R.id.editTextTextPersonName);
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextName.setText(name);
        editTextEmail.setText(email);
        Button saveChangesBtn = findViewById(R.id.saveChangesBtn);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiInterface.updateChanges(editTextEmail.getText().toString().trim(), editTextName.getText().toString()).enqueue(new Callback<List<UpdateChangesModel>>() {
                    @Override
                    public void onResponse(Call<List<UpdateChangesModel>> call, Response<List<UpdateChangesModel>> response) {
                        Toast.makeText(getApplicationContext(), "Updated...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<UpdateChangesModel>> call, Throwable t) {

                    }
                });
            }
        });

    }
}






