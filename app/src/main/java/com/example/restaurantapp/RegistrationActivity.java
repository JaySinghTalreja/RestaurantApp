package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    public static final String IS_USER_LOGIN = "IsUserLoggedIn";
    private static final String PREFER_NAME = "AndroidExamplePref";
    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";
    // Email address (make variable public to access from outside)
    public static final String KEY_PASSWORD = "password";

    EditText usernameEditText, passwordEditText;
    Button signUpBtn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpBtn = findViewById(R.id.signUpBtn);

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameData = usernameEditText.getText().toString();
                String userPasswordData = passwordEditText.getText().toString();
                if(validateInputs(userNameData, userPasswordData)) {
                    editor.putBoolean(IS_USER_LOGIN, true);
                    editor.putString(KEY_NAME, userNameData);
                    editor.putString(KEY_PASSWORD, userPasswordData);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_SHORT).show();
                    LoginNow();
                }
            }
        });

    }

    private void LoginNow() {
        Intent intent = new Intent(getApplicationContext(), Restaurant.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    private boolean validateInputs(String userNameData, String userPasswordData) {
        boolean flag = true;
        if(userNameData.length() == 0 && userPasswordData.length()==0) {
            Toast.makeText(this, "No Username and Password Provided", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        else if(userNameData.length() == 0) {
            Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        else if(userPasswordData.length() == 0){
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        return flag;
    }
}