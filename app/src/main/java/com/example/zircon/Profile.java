package com.example.zircon;

import android.app.ProgressDialog;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.ProfileModel;

import java.util.List;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import de.hdodenhof.circleimageview.CircleImageView;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {


    Button btn;
    String email;
    ApiInterface apiInterface;
    CircleImageView user_profile_image;
    FirebaseStorage storage;
    StorageReference storageReference;
    String name, user_id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email = getIntent().getStringExtra("email");
        user_id = getIntent().getStringExtra("user_id");
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        user_profile_image = findViewById(R.id.user_profile_image);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        getDetails();

        StorageReference ref
                = storageReference
                .child(
                        "images/");

        ref.child(user_id).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(Profile.this)
                        .load(uri)
                        .into(user_profile_image);
            }
        });

        btn = (Button) findViewById(R.id.editBtn);
        btn.setOnClickListener(view -> {
            System.out.println("Inside button click");
            Intent intent = new Intent(Profile.this, Portfolio.class
            );
            intent.putExtra("email", email);
            intent.putExtra("name", name);
            intent.putExtra("id", String.valueOf(user_id));
            startActivity(intent);
        });

    }

    private void getDetails() {
        Call<List<ProfileModel>> getDetails = apiInterface.getUserDetails(email);

        getDetails.enqueue(new Callback<List<ProfileModel>>() {
            @Override
            public void onResponse(Call<List<ProfileModel>> call, Response<List<ProfileModel>> response) {
                List<ProfileModel> list = response.body();
                assert list != null;
                name = list.get(0).getName();
                user_id = String.valueOf(list.get(0).getId());

            }

            @Override
            public void onFailure(Call<List<ProfileModel>> call, Throwable t) {

            }
        });
    }
}