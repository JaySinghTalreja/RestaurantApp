package com.example.restaurantapp;

public class RestaurantData {
    private String restaurantName;
    private String addressData;
    private Integer restaurantImage;
    private double latitudeData;
    private double longitudeData;

    public RestaurantData(String restaurantName, String addressData, Integer restaurantImage, double latitudeData, double longitudeData) {
        this.restaurantName = restaurantName;
        this.addressData = addressData;
        this.restaurantImage = restaurantImage;
        this.latitudeData = latitudeData;
        this.longitudeData = longitudeData;
    }

    //Setters
    public void setRestaurentName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public void setAddressData(String addressData) {
        this.addressData = addressData;
    }
    public void setRestaurentImage(Integer restaurantImage) {
        this.restaurantImage = restaurantImage;
    }
    public void setLatitudeData(double latitudeData) {
        this.latitudeData = latitudeData;
    }
    public void setLongitudeData(double longitudeData) {
        this.longitudeData = longitudeData;
    }

    //Getters
    public String getRestaurantName() {
        return this.restaurantName;
    }
    public String getAddressData() {
        return this.addressData;
    }
    public Integer getRestaurantImage() {return this.restaurantImage;}
    public double getLatitudeData() {return this.latitudeData;}
    public double getLongitudeData() {return this.longitudeData;}

}

