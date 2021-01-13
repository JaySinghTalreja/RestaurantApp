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

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditTextLogin, passwordEditTextLogin;
    Button loginBtnLogin, alreadyHaveAnAccount;

    private static final String PREFER_NAME = "AndroidExamplePref";

    // All Shared Preferences Keys
    public static final String IS_USER_LOGIN = "IsUserLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_PASSWORD = "password";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Map<String, ?> varMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditTextLogin = findViewById(R.id.usernameEditTextLogin);
        passwordEditTextLogin = findViewById(R.id.passwordEditTextLogin);
        loginBtnLogin = findViewById(R.id.loginBtnLogin);
        alreadyHaveAnAccount = findViewById(R.id.alreadyHaveAnAccount);

        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(isUserLoggedIn()) {
            LoginNow();
        }

        loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Copying Data from Login Fields to Shared Preference
                String userNameData = usernameEditTextLogin.getText().toString();
                String userPasswordData = passwordEditTextLogin.getText().toString();
                if(validateInputs(userNameData, userPasswordData)) {
                    editor.putBoolean(IS_USER_LOGIN, true);
                    editor.commit();
                    LoginNow();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Credentials Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean validateInputs(String userNameData, String userPasswordData) {
        boolean flag = true;
        if(userNameData.length() == 0 && userPasswordData.length()==0) {
            Toast.makeText(this, "No Username and Password Provided", Toast.LENGTH_SHORT).show();
            usernameEditTextLogin.setError("Invalid Name");
            flag = false;
        }
        else if(userNameData.length() == 0) {
            Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        else if(userPasswordData.length() == 0) {
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        HashMap<String, String> user = getUserDetails();
        String nameCheck = user.get(KEY_NAME);
        String passwordCheck = user.get(KEY_PASSWORD);

        //DOUBT

        if((nameCheck == null || passwordCheck == null) || (!nameCheck.equals(userNameData) || !passwordCheck.equals(userPasswordData))) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
        return flag;
    }

    /* DOUBT METHOD */
    private HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        //name
        user.put(KEY_NAME, sharedPreferences.getString(KEY_NAME, null));
        user.put(KEY_PASSWORD, sharedPreferences.getString(KEY_PASSWORD, null));
        return user;
    }

    private void LoginNow() {
        Intent intent = new Intent(this, Restaurant.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public boolean isUserLoggedIn() {
        return sharedPreferences.getBoolean(IS_USER_LOGIN, false);
    }

}