package com.example.zircon;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.RoomModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Room extends BaseActivity {
    final Calendar myCalendar = Calendar.getInstance();
    EditText editText;

    EditText titleTIL, descriptionTIL,
    //            starttimeTIL,endtimeTIL,
    numberOfParticipantsTIL, durationTIL, startdateTIL, enddateTIL, recitationTargetTIL;

    String date1, date2;
    Spinner selecttypeTIL, selectstatusTIL;
    String str_selecttype, str_selectstatus;

    String[] selectTYPEE = {"individual", "community"};

    String[] selectSTATUS = {"One Time","Daily", "Weekly", "Monthly"};

    SharedPreferences.Editor editor;
    Button submit;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = preferences.edit();

//        int myInt = preferences.getInt(getIntent().getStringExtra("title"), 0);
        //      DoneBtn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Intent intent= new Intent(Room.this,Zikr.class);
//               startActivity(intent);
//           }
//       });


        submit = findViewById(R.id.submit);

        titleTIL = (EditText) findViewById(R.id.title);

        descriptionTIL = (EditText) findViewById(R.id.discription);
//        starttimeTIL = (EditText) findViewById(R.id.starttime);
//        endtimeTIL = (EditText) findViewById(R.id.endtime);
        selecttypeTIL = (Spinner) findViewById(R.id.selecttype);
        enddateTIL = (EditText) findViewById(R.id.enddate);
        selectstatusTIL = (Spinner) findViewById(R.id.selectstatus);
        recitationTargetTIL = (EditText) findViewById(R.id.recitationtarget);
        numberOfParticipantsTIL = (EditText) findViewById(R.id.numberOfParticipants);
        durationTIL = (EditText) findViewById(R.id.duration);

        startdateTIL = (EditText) findViewById(R.id.startdate);


        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        ArrayAdapter sType = new ArrayAdapter(this, android.R.layout.simple_spinner_item, selectTYPEE);
        sType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        selecttypeTIL.setAdapter(sType);


        ArrayAdapter sSTATUS = new ArrayAdapter(this, android.R.layout.simple_spinner_item, selectSTATUS);
        sSTATUS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        selectstatusTIL.setAdapter(sSTATUS);


        selecttypeTIL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_selecttype = selectTYPEE[i];
                if (str_selecttype.equals("community")) {
                    numberOfParticipantsTIL.setVisibility(View.VISIBLE);
                } else {
                    numberOfParticipantsTIL.setVisibility(View.GONE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        selectstatusTIL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                str_selectstatus = selectSTATUS[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//        Button doneBtn = (Button) findViewById(R.id.doneBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Room.this, "Clicked", Toast.LENGTH_SHORT).show();
                onDoneBtn();
            }
        });

        startdateTIL.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {

                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, day);
                        updatestart();


                    }
                };
                new DatePickerDialog(Room.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        enddateTIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, day);
                        updateEnd();


                    }
                };
                new DatePickerDialog(Room.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }


    private void updatestart() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        startdateTIL.setText(dateFormat.format(myCalendar.getTime()));


    }

    private void updateEnd() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        enddateTIL.setText(dateFormat.format(myCalendar.getTime()));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        try {
            Date start = sdf.parse(String.valueOf(startdateTIL.getText()));
            Date end = sdf.parse(String.valueOf(enddateTIL.getText()));

            durationTIL.setText(Long.toString(getDateDiff(start, end, TimeUnit.DAYS)));
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }


    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }


    public void onDoneBtn() {

        String str_title = titleTIL.getText().toString();
        String str_description = descriptionTIL.getText().toString();

        String str_starttime = "";//starttimeTIL.getText().toString();
        String str_endtime = "";//endtimeTIL.getText().toString();

        String str_numberOfParticipants = numberOfParticipantsTIL.getText().toString();
        String str_duration = durationTIL.getText().toString();
        String str_startdate = startdateTIL.getText().toString();
        String str_enddate = enddateTIL.getText().toString();

        String str_recitationTarget = recitationTargetTIL.getText().toString();

        String userId = "15";//getIntent().getStringExtra("id");


        executor.execute(() -> {
            String uid = String.valueOf(System.currentTimeMillis());
            HashMap<String, Object> UserMap = new HashMap<>();
//            HashMap<String, Object> UserMap1 = new HashMap<>();
            // UserMap.put("pid", uid);
            UserMap.put("type", String.valueOf(str_selecttype));
            UserMap.put("title", String.valueOf(str_title));

            UserMap.put("start_date", str_startdate);

            //storageReference.child("Images").child(uid).child(saveImageUri);
            rootRef.getReference().child("notification").child(uid).updateChildren(UserMap)

                    .addOnCompleteListener(task1 ->
                            runOnUiThread(() -> {

                                editor.putBoolean("check", true).apply();

                                //binding.progressLinear.setVisibility(View.GONE);
                                //                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                //Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                                //   startActivity(new Intent(this,MainActivity.class));
                            }))
                    .addOnFailureListener(task1 -> {
                                Log.d("TAG", "onDoneBtn: " + task1);
                                Toast.makeText(this, "" + task1.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                    );

        });


        if (str_selecttype.equals("community")) {
            Call<RoomModel> createroomCall = apiInterface.createRoomCom(str_title,
                    str_description,
                    str_starttime,
                    str_endtime,
                    str_selecttype,
                    str_numberOfParticipants,
                    str_duration,
                    str_startdate,
                    str_enddate,
                    str_selectstatus,
                    str_recitationTarget,
                    userId);
            createroomCall.enqueue(new Callback<RoomModel>() {
                @Override
                public void onResponse(Call<RoomModel> call, Response<RoomModel> response) {

                    if (response.isSuccessful()) {
//                    Log.d("ROOMAPIRESP", );

                        RoomModel createRoomResponse = response.body();

                        Toast.makeText(Room.this, "resp" + createRoomResponse.getRoomid(), Toast.LENGTH_SHORT).show();

                        Intent zikrIntent = new Intent(Room.this, CreateZikrroom.class);
                        zikrIntent.putExtra("id", createRoomResponse.getRoomid());
                        zikrIntent.putExtra("status", str_selecttype);
                        startActivity(zikrIntent);
//                   Intent createintent=new Intent(getActivity(),Home.class);

//                    loginintent.putExtra("email",userdetails.get(0).getEmail());
//                    loginintent.putExtra("username",userdetails.get(0).getName());
//                    loginintent.putExtra("id",userdetails.get(0).getId());
//                startActivity(createintent);

                    } else {
                        Toast.makeText(Room.this, "Response Was not Successfull", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<RoomModel> call, Throwable t) {
                    Toast.makeText(Room.this, t.toString(), Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });


        } else {

            Call<RoomModel> createroomCall = apiInterface.createRoom(str_title,
                    str_description,
                    str_starttime,
                    str_endtime,
                    str_selecttype,
                    str_numberOfParticipants,
                    str_duration,
                    str_startdate,
                    str_enddate,
                    str_selectstatus,
                    str_recitationTarget,
                    userId);
            createroomCall.enqueue(new Callback<RoomModel>() {
                @Override
                public void onResponse(Call<RoomModel> call, Response<RoomModel> response) {

                    if (response.isSuccessful()) {
//                    Log.d("ROOMAPIRESP", );

                        RoomModel createRoomResponse = response.body();
//                        if (createRoomResponse.size() > 0) {
                        Toast.makeText(Room.this, "resp" + createRoomResponse.getRoomid(), Toast.LENGTH_SHORT).show();

                        Intent zikrIntent = new Intent(Room.this, CreateZikrroom.class);
                        zikrIntent.putExtra("room_id", createRoomResponse.getRoomid());
                        zikrIntent.putExtra("status", str_selecttype);
                        startActivity(zikrIntent);
//                   Intent createintent=new Intent(getActivity(),Home.class);

//                    loginintent.putExtra("email",userdetails.get(0).getEmail());
//                    loginintent.putExtra("username",userdetails.get(0).getName());
//                    loginintent.putExtra("id",userdetails.get(0).getId());
//                startActivity(createintent);
//                        }
                    } else {
                        Toast.makeText(Room.this, "Response Was not Successfull", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<RoomModel> call, Throwable t) {
                    Toast.makeText(Room.this, t.toString(), Toast.LENGTH_SHORT).show();

                    t.printStackTrace();
                }
            });
        }


    }


}