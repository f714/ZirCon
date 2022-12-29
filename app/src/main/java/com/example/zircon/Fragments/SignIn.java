package com.example.zircon.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zircon.Home;
import com.example.zircon.R;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.User;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignIn extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ApiInterface apiInterface;

    private Button signInBtn;
    private TextInputLayout emailTIL, passwordTIL;
    private TextView errorTv;

    public SignIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignIn.
     */
    // TODO: Rename and change types and number of parameters
    public static SignIn newInstance(String param1, String param2) {
        SignIn fragment = new SignIn();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        System.out.println(apiInterface);


        emailTIL = (TextInputLayout) view.findViewById(R.id.email);
        passwordTIL = (TextInputLayout) view.findViewById(R.id.password);

//        errorTv = (TextView)view.findViewById(R.id.errorTv);

        signInBtn = (Button) view.findViewById(R.id.login);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "jamshaid", Toast.LENGTH_SHORT).show();
                ;
                Call<List<User>> signInCall = apiInterface.loginUser(

                        emailTIL.getEditText().getText().toString(),
                        passwordTIL.getEditText().getText().toString());
                signInCall.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        if (response.isSuccessful()) {

                            List<User> userdetails = response.body();
                            Toast.makeText(getActivity(), "" + userdetails.get(0).getName(), Toast.LENGTH_SHORT).show();
                            Intent loginintent = new Intent(getActivity(), Home.class);

                            loginintent.putExtra("username", userdetails.get(0).getName());
                            loginintent.putExtra("email", userdetails.get(0).getEmail());
                            loginintent.putExtra("id", userdetails.get(0).getId());
                            startActivity(loginintent);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        return view;
    }
}