package com.example.zircon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CureDiseases extends AppCompatActivity {

    ImageView eyeIV;
    ImageView noseIV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cure_diseases);

        eyeIV= (ImageView) findViewById(R.id.eyeIV);

      eyeIV.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent eyeBtnIntent=new Intent(CureDiseases.this,EyeAmal.class);

              startActivity(eyeBtnIntent);
          }
      });

      noseIV=(ImageView) findViewById(R.id.noseIV);
      noseIV.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent noseIVIntent=new Intent(CureDiseases.this,NoseAmal.class);
              startActivity(noseIVIntent);
          }
      });
    }
}