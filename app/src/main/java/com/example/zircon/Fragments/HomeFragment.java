package com.example.zircon.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zircon.CureDiseases;
import com.example.zircon.Daily_Verses;
import com.example.zircon.Favourite;
import com.example.zircon.My_Rooms;
import com.example.zircon.NotificationActivity;
import com.example.zircon.PersonalRoom;
import com.example.zircon.Profile;
import com.example.zircon.R;
import com.example.zircon.Room;
import com.example.zircon.RoomTracker;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.LoadMyRoomsModel;
import com.example.zircon.rcvadapters.MyRoomsRecyclerviewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "email";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    private FloatingActionButton createroomBtn;
    private FloatingActionButton myroomBtn;
    private FloatingActionButton cureBtn;
    private FloatingActionButton inspirationBtn;
    private FloatingActionButton personalTrackerBtn;
    private FloatingActionButton versesBtn;

    private ImageView profileIc;
    private ImageView notificationIv;

    private TextView titleTV;
    SharedPreferences.Editor editor;

    ApiInterface apiInterface;
    RecyclerView roomRcv;
    MyRoomsRecyclerviewAdapter adapter;
    List<LoadMyRoomsModel> allRooms;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    String email, user_id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        email = requireActivity().getIntent().getStringExtra("email");
        user_id = requireActivity().getIntent().getStringExtra("user_id");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TabLayout tabLayout;
        ViewPager viewPager1;
        tabLayout = view.findViewById(R.id.tabtoday);
        viewPager1 = view.findViewById(R.id.viewtoday);
        viewPager1.setAdapter(new FragmentThirdAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager1);

        createroomBtn = view.findViewById(R.id.createroomBtn);

        versesBtn = view.findViewById(R.id.versesBtn);
        notificationIv = view.findViewById(R.id.bell_iv);
        profileIc = view.findViewById(R.id.profileIc);
        titleTV = view.findViewById(R.id.titleTV);


        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        roomRcv = view.findViewById(R.id.roomRcv);


        Call<List<LoadMyRoomsModel>> myRoomCall = apiInterface.loadMyRooms("community", user_id);
        myRoomCall.enqueue(new Callback<List<LoadMyRoomsModel>>() {
            @Override
            public void onResponse(Call<List<LoadMyRoomsModel>> call, Response<List<LoadMyRoomsModel>> response) {
                if (response.isSuccessful()) {
                    allRooms = response.body();

                    for (LoadMyRoomsModel myRoom : allRooms) {
//                        Toast.makeText(My_Rooms.this, myRoom.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                    adapter = new MyRoomsRecyclerviewAdapter(getActivity(), allRooms);
                    adapter.setClickListener((view1, position) -> {
                        Paper.init(getActivity());
                        Paper.book().write(
                                "img",
                                String.valueOf(allRooms.get(position).getNarrator())
                        );

                        Toast.makeText(getActivity(), allRooms.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                        Intent personalIntent = new Intent(getActivity(), PersonalRoom.class);
                        personalIntent.putExtra("title", allRooms.get(position).getTitle());
                        personalIntent.putExtra("id", "15");
                        personalIntent.putExtra("start_date", allRooms.get(position).getStart_date());

                        personalIntent.putExtra("zikr_counting", allRooms.get(position).getZikr_counting());
                        personalIntent.putExtra("status", allRooms.get(position).getStatus());
                        personalIntent.putExtra("user_id", user_id);

                        startActivity(personalIntent);
                    });
                    roomRcv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
                    roomRcv.setAdapter(adapter);

                } else {
                    Toast.makeText(getActivity(), "Error in loading rooms", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<LoadMyRoomsModel>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        checkBool();

        createroomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent createroomintent = new Intent(getActivity(), Room.class);
                startActivity(createroomintent);

            }
        });
        notificationIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), NotificationActivity.class);
                intent.putExtra("user_id", user_id);
                startActivity(intent);

            }
        });

        profileIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentprofile = new Intent(getActivity(), Profile.class);
                intentprofile.putExtra("email", email);
                intentprofile.putExtra("user_id", user_id);
                startActivity(intentprofile);
            }
        });


        myroomBtn = view.findViewById(R.id.myroomBtn);

        myroomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("TAG", "onClick:idddd" + getActivity().getIntent().getStringExtra("id"));
                Intent myroomintent = new Intent(getActivity(), My_Rooms.class);
                myroomintent.putExtra("id", getActivity().getIntent().getStringExtra("id"));
                startActivity(myroomintent);
            }
        });


        cureBtn = view.findViewById(R.id.cureBtn);
        cureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cureBtnintent = new Intent(getActivity(), CureDiseases.class);
                startActivity(cureBtnintent);
            }
        });


        inspirationBtn = view.findViewById(R.id.inspirationBtn);
        inspirationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent inspirationBtnIntent = new Intent(getActivity(), Favourite.class);
                startActivity(inspirationBtnIntent);
            }
        });
        versesBtn = view.findViewById(R.id.versesBtn);
        versesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent versesBtnintent = new Intent(getActivity(), Daily_Verses.class);
                startActivity(versesBtnintent);
            }
        });

        personalTrackerBtn = view.findViewById(R.id.personalTrackerBtn);
        personalTrackerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent personalTrackerBtnIntent = new Intent(getActivity(), RoomTracker.class);
                startActivity(personalTrackerBtnIntent);
            }
        });
        return view;
    }

    public void checkBool() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireActivity());
        editor = preferences.edit();

        Boolean bool = preferences.getBoolean("check", false);

        if (bool) {
            notificationIv.setImageResource(R.drawable.notification_icon);
        } else {
            notificationIv.setImageResource(R.drawable.ic_bell_noti);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        checkBool();
    }

    @Override
    public void onResume() {
        super.onResume();
        checkBool();
    }

}