package com.example.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantDataAdapter extends RecyclerView.Adapter<RestaurantDataAdapter.ViewHolder> {
    RestaurantData[] restaurantData;
    Context context;

    public static final String CORD_KEY = "CordKey";

    //Constructor
    public RestaurantDataAdapter(RestaurantData[] restaurantData,Restaurant activity) {
        this.restaurantData = restaurantData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RestaurantData myRestaurantData = restaurantData[position];
        holder.restaurantImageView.setImageResource(myRestaurantData.getRestaurantImage());
        holder.restaurantNameView.setText(myRestaurantData.getRestaurantName());
        holder.restaurantAddressView.setText(myRestaurantData.getAddressData());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapsIntent = new Intent(context.getApplicationContext(), GoogleMapsPlotter.class);
                mapsIntent.putExtra(CORD_KEY, new double[]{myRestaurantData.getLatitudeData(), myRestaurantData.getLongitudeData()});
                context.startActivity(mapsIntent);
                //Toast.makeText(context, myRestaurantData.getRestaurantName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView restaurantImageView;
        TextView restaurantNameView;
        TextView restaurantAddressView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantImageView = itemView.findViewById(R.id.restaurantImageView);
            restaurantAddressView = itemView.findViewById(R.id.restaurantAddressView);
            restaurantNameView = itemView.findViewById(R.id.restaurantNameView);
        }
    }
}
