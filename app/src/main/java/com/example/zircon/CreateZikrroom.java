package com.example.zircon;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.ZikrModel;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateZikrroom extends AppCompatActivity {

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    TextView titleET;
    EditText descriptionET, countingET;
//    Spinner selectLanguageET;

    String imageurl="";
    //    String str_selectLanguage;
    Bitmap bitmap;
    //    String[] selectLanguage = {"Arabic", "Urdu"};
    AppCompatImageView addImage, setImage;
    String status;
    ApiInterface apiInterface;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zikr);

        status = getIntent().getStringExtra("status");
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        titleET = (TextView) findViewById(R.id.title);

        descriptionET = (EditText) findViewById(R.id.description);
//        selectLanguageET= (Spinner) findViewById(R.id.selectlanguage);
//        narratorET = (EditText) findViewById(R.id.narrator);
//        numberOfAyatsEt = (EditText) findViewById(R.id.number_of_ayats);
        countingET = (EditText) findViewById(R.id.counting);


        Button postBtn = (Button) findViewById(R.id.postBtn);
        addImage = (AppCompatImageView) findViewById(R.id.select_image);
        setImage = (AppCompatImageView) findViewById(R.id.set_image);

        addImage.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);
        });
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPostBtn();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            Uri imageUri = data.getData();
            try {
                 bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                setImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


//             File file = new File(imageUri.getPath());
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }





//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
//            byte[] imageBytes = byteArrayOutputStream.toByteArray();
//            imageBase = Base64.encodeToString(imageBytes, Base64.DEFAULT);

        }
    }
    // Put the image file path into this method



    public void onPostBtn() {

           if (bitmap!=null){
               uploadImage(bitmap);
           }else {
               String uniqueid = String.valueOf(System.currentTimeMillis());
               String str_title = titleET.getText().toString();
               String str_description = descriptionET.getText().toString();

//        String str_narrator = narratorET.getText().toString();
//        String str_number_of_ayat = numberOfAyatsEt.getText().toString();

               String str_counting = countingET.getText().toString();
               String str_room_id = countingET.getText().toString();


//        String userId = "15";//getIntent().getStringExtra("id");

               Call<List<ZikrModel>> addzikrCall = apiInterface.addZikr(str_title,
                       str_description,
                       "",
                       "",
                       str_counting,
                       status,
                       getIntent().getExtras().getString("id"));

//        userId);

               addzikrCall.enqueue(new Callback<List<ZikrModel>>() {
                   @Override
                   public void onResponse(Call<List<ZikrModel>> call, Response<List<ZikrModel>> response) {

                       if (response.isSuccessful()) {
//                    Log.d("ROOMAPIRESP", );

                           List<ZikrModel> addzikrResponse = response.body();
                           Toast.makeText(CreateZikrroom.this, "resp " + addzikrResponse.get(0).getResponse(), Toast.LENGTH_SHORT).show();
//                    Intent createintent=new Intent(getActivity(),Home.class);

//                    loginintent.putExtra("email",userdetails.get(0).getEmail());
//                    loginintent.putExtra("username",userdetails.get(0).getName());
//                    loginintent.putExtra("id",userdetails.get(0).getId());
//                    startActivity(createintent);
                       } else {

                           Toast.makeText(CreateZikrroom.this, "Response Was not Successfull", Toast.LENGTH_SHORT).show();
                       }

                   }

                   @Override
                   public void onFailure(Call<List<ZikrModel>> call, Throwable t) {

                       Toast.makeText(CreateZikrroom.this, t.toString(), Toast.LENGTH_SHORT).show();
                       t.printStackTrace();
                   }
               });
           }











    }
    private void uploadImage(Bitmap bitmap) {
        ProgressDialog progressDialog = new ProgressDialog(CreateZikrroom.this);
        progressDialog.setMessage("loading");
        progressDialog.show();
        FirebaseStorage storageReference = FirebaseStorage.getInstance();
        final StorageReference ref = storageReference.getReference().child("drivers/" + System.currentTimeMillis() + ".jpg");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
        byte[] data = baos.toByteArray();

        final UploadTask uploadTask = ref.putBytes(data);
        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                progressDialog.dismiss();
                Toast.makeText(CreateZikrroom.this, "Uploaded", Toast.LENGTH_SHORT).show();

                uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }

                        return
                                ref.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downUri = task.getResult();
                            String uniqueid = String.valueOf(System.currentTimeMillis());
                            String str_title = titleET.getText().toString();
                            String str_description = descriptionET.getText().toString();

//        String str_narrator = narratorET.getText().toString();
//        String str_number_of_ayat = numberOfAyatsEt.getText().toString();

                            String str_counting = countingET.getText().toString();
                            String str_room_id = countingET.getText().toString();


//        String userId = "15";//getIntent().getStringExtra("id");

                            Call<List<ZikrModel>> addzikrCall = apiInterface.addZikr(str_title,
                                    str_description,
                                    downUri.toString(),
                                    "",
                                    str_counting,
                                    status,
                                    getIntent().getExtras().getString("id"));

//        userId);

                            addzikrCall.enqueue(new Callback<List<ZikrModel>>() {
                                @Override
                                public void onResponse(Call<List<ZikrModel>> call, Response<List<ZikrModel>> response) {

                                    if (response.isSuccessful()) {
//                    Log.d("ROOMAPIRESP", );
                                        progressDialog.dismiss();
                                        List<ZikrModel> addzikrResponse = response.body();
                                        Toast.makeText(CreateZikrroom.this, "resp " + addzikrResponse.get(0).getResponse(), Toast.LENGTH_SHORT).show();
//                    Intent createintent=new Intent(getActivity(),Home.class);

//                    loginintent.putExtra("email",userdetails.get(0).getEmail());
//                    loginintent.putExtra("username",userdetails.get(0).getName());
//                    loginintent.putExtra("id",userdetails.get(0).getId());
//                    startActivity(createintent);
                                    } else {
                                        progressDialog.dismiss();
                                        Toast.makeText(CreateZikrroom.this, "Response Was not Successfull", Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<List<ZikrModel>> call, Throwable t) {
                                    progressDialog.dismiss();
                                    Toast.makeText(CreateZikrroom.this, t.toString(), Toast.LENGTH_SHORT).show();
                                    t.printStackTrace();
                                }
                            });

                            Log.d("Final URL", "onComplete: Url: " + downUri.toString());
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(CreateZikrroom.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    }
