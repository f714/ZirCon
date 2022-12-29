package com.example.zircon.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zircon.Home;
import com.example.zircon.R;
import com.example.zircon.api.ApiClient;
import com.example.zircon.api.ApiInterface;
import com.example.zircon.api.models.User;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUp extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ApiInterface apiInterface;

    private Button signupBtn;
    private TextInputLayout nameTIL, emailTIL, passwordTIL, confirmPasswordTIL;
    private TextView errorTv;

    public SignUp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUp.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUp newInstance(String param1, String param2) {
        SignUp fragment = new SignUp();
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


        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        nameTIL = view.findViewById(R.id.userName);
        emailTIL = view.findViewById(R.id.email);
        passwordTIL = view.findViewById(R.id.password);
        confirmPasswordTIL = view.findViewById(R.id.confirmPassword);
        errorTv = view.findViewById(R.id.errorTv);

        signupBtn = view.findViewById(R.id.signupBtn);


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Testing Signup", "ok");

                String p1 = passwordTIL.getEditText().getText().toString();
                String p2 = confirmPasswordTIL.getEditText().getText().toString();

//                    errorTv.setText(p1 + "\n"+ p2);
                if (TextUtils.equals(p1, p2)) {
                    //Replace hard coded values with text field values
                    Call<List<User>> signupCall = apiInterface.signupUser(
                            nameTIL.getEditText().getText().toString(),
                            emailTIL.getEditText().getText().toString(),
                            passwordTIL.getEditText().getText().toString());
                    signupCall.enqueue(new Callback<List<User>>() {
                        @Override
                        public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                            if (response.isSuccessful()) {
                                List<User> usr = response.body();
                                if (usr.size() > 0) {
                                    for (User us : usr) {
                                        Log.d("Response Successful", us.getEmail());

                                        Intent loginintent = new Intent(getActivity(), Home.class);

                                        loginintent.putExtra("username", us.getName());
                                        loginintent.putExtra("email", us.getEmail());
                                        loginintent.putExtra("id", us.getId());
                                        startActivity(loginintent);
                                    }
                                } else {
                                    errorTv.setText("Unable to Signup");
                                }

                            } else {
                                Log.d("Response Failed", "");
                                errorTv.setText("Signup Api Response Failed");
                            }
                        }

                        @Override
                        public void onFailure(Call<List<User>> call, Throwable t) {
                            Log.d("Error While Signup", t.getMessage());
                            errorTv.setText("Error While Signup " + t.getMessage());
                        }
                    });

                } else {
                    errorTv.setText("Confirm Password Doesn't Match");
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}