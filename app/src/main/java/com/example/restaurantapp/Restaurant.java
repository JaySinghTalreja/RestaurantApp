package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Restaurant extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    //Button logOutBtn;


    public static final String IS_USER_LOGIN = "IsUserLoggedIn";
    private static final String PREFER_NAME = "AndroidExamplePref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(8);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        RestaurantData[] restaurantData = new RestaurantData[]{
                new RestaurantData("Restaurant 1", "Address 1", R.drawable.nine, 18.5204, 73.8567),
                new RestaurantData("Restaurant 2", "Address 2", R.drawable.nine, 19.0760, 72.8777),
                new RestaurantData("Restaurant 3", "Address 3", R.drawable.nine, 21.1458, 79.0882),
                new RestaurantData("Restaurant 4", "Address 4", R.drawable.nine, 17.3850, 78.4867),
                new RestaurantData("Restaurant 5", "Address 5", R.drawable.nine, 12.9716, 77.5946),
                new RestaurantData("Restaurant 6", "Address 6", R.drawable.nine, 19.2183, 72.9781),
                new RestaurantData("Restaurant 7", "Address 7", R.drawable.nine, 15.2993, 74.1240),
                new RestaurantData("Restaurant 8", "Address 8", R.drawable.nine, 26.9124, 75.7873)
        };

        RestaurantDataAdapter restaurantDataAdapter = new RestaurantDataAdapter(restaurantData, Restaurant.this);
        recyclerView.setAdapter(restaurantDataAdapter);
        /*
        logOutBtn = findViewById(R.id.logOutBtn);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences = getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putBoolean(IS_USER_LOGIN, false);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

         */
    }
}