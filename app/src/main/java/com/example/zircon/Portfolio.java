package com.example.zircon;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.UpdateChangesModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Portfolio extends AppCompatActivity {
    ApiInterface apiInterface;
    private Button saveChangesBtn;
    private TextInputLayout emailTIL, nameTIL;
    CircleImageView circleImageView;
    FirebaseStorage storage;
    StorageReference storageReference;
    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        user_id = getIntent().getStringExtra("id");

        EditText editTextName = findViewById(R.id.editTextTextPersonName);
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        editTextName.setText(name);
        editTextEmail.setText(email);
        saveChangesBtn = findViewById(R.id.saveChangesBtn);
        circleImageView = findViewById(R.id.imageView5);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        saveChangesBtn.setOnClickListener(view ->

                apiInterface.updateChanges(editTextEmail.getText().toString(), editTextName.getText().toString(), editTextPassword.getText().toString()).enqueue(new Callback<List<UpdateChangesModel>>() {
                    @Override
                    public void onResponse(Call<List<UpdateChangesModel>> call, Response<List<UpdateChangesModel>> response) {
                        Toast.makeText(getApplicationContext(), "Update Status: " + response.body().get(0).getUpdate_status(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<List<UpdateChangesModel>> call, Throwable t) {

                    }
                }));

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();

            }
        });


        StorageReference ref
                = storageReference
                .child(
                        "images/");
        ref.child(user_id).getDownloadUrl().addOnSuccessListener(uri -> Glide.with(Portfolio.this)
                .load(uri)
                .into(circleImageView));


    }

    int SELECT_PICTURE = 200;

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    Uri filePath;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                filePath = data.getData();
                if (null != filePath) {
                    // update the preview image in the layout
                    circleImageView.setImageURI(filePath);
                    uploadImage();
                }
            }
        }
    }

    private void uploadImage() {
        if (filePath != null) {

            // Defining the child of storageReference
            StorageReference ref
                    = storageReference
                    .child(
                            "images/");
            ref.child(user_id).getDownloadUrl().addOnSuccessListener(uri -> Glide.with(Portfolio.this)
                    .load(uri)
                    .into(circleImageView));

            // adding listeners on upload
            // or failure of image
            ref.child(user_id).putFile(filePath)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot) {

                                    // Image uploaded successfully
                                    // Dismiss dialog
//                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(Portfolio.this,
                                                    "Image Uploaded!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            // Error, Image not uploaded
                            Toast
                                    .makeText(Portfolio.this,
                                            "Failed " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot) {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
//                                    progressDialog.setMessage(
//                                            "Uploaded "
//                                                    + (int)progress + "%");
                                }
                            });
        }
    }

}






