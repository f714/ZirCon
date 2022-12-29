package com.example.zircon.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zircon.My_Rooms;
import com.example.zircon.R;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.LoadHomeTodayInProgressModel;
import com.example.zircon.api.models.LoadMyRoomsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ApiInterface apiInterface;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TodayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodayFragment newInstance(String param1, String param2) {
        TodayFragment fragment = new TodayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today, container, false);

//        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        String userId = getActivity().getIntent().getStringExtra("id");
//        Call<List<LoadHomeTodayInProgressModel>> myRoomCall = apiInterface.homeTodayInProgress("individual",userId);
//        myRoomCall.enqueue(new Callback<List<LoadHomeTodayInProgressModel>>() {
//            @Override
//            public void onResponse(Call<List<LoadHomeTodayInProgressModel>> call, Response<List<LoadHomeTodayInProgressModel>> response) {
//                if(response.isSuccessful()) {
//                    List<LoadHomeTodayInProgressModel> allRooms = response.body();
//
//                    for (LoadHomeTodayInProgressModel myRoom: allRooms) {
//                        Toast.makeText(getActivity(), myRoom.getTitle(), Toast.LENGTH_SHORT).show();
//                    }
//
//                } else {
//                    Toast.makeText(getActivity(), "Error in loading rooms", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<LoadHomeTodayInProgressModel>> call, Throwable t) {
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }
}