package com.example.zircon;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;
    FirebaseDatabase rootRef;
//    StorageReference storageReference;

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_base);

        mAuth = FirebaseAuth.getInstance();
        rootRef = FirebaseDatabase.getInstance();
//        storageReference = FirebaseStorage.getInstance().getReference();

    }

    Boolean checkConditionEdittext(EditText editText, String toast) {
        if (TextUtils.isEmpty(editText.getText().toString())) {
            editText.setError(toast);
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    Boolean checkConditionTextview(TextView textView, String toast) {
        if (TextUtils.isEmpty(textView.getText().toString())) {
            textView.setError(toast);
            textView.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void showPassword(@NonNull EditText editText, ImageView imageView) {
        if (editText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT |
                    InputType.TYPE_TEXT_VARIATION_PASSWORD);
            imageView.setColorFilter(getResources().getColor(R.color.black));

        } else {
            editText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            imageView.setColorFilter(getResources().getColor(R.color.purple_200));
        }
        editText.setSelection(Objects.requireNonNull(editText.getText()).length());
    }

    public boolean isValidPassword(@NonNull EditText editText) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(editText.getText().toString());
        if (!matcher.matches()) {
            editText.setError("Your Password Must have Uppercase letters: A-Z. Lowercase letters: a-z. Numbers: 0-9. Special Characters @,#,$,%");
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidEmail(@NonNull EditText editText) {
        if (TextUtils.isEmpty(editText.getText().toString()) && Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString()).matches()) {
            editText.setError("Please Enter Valid Email");
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }
}