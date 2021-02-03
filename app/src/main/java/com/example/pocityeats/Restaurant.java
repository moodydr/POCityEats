package com.example.pocityeats;

public class Restaurant {
    private int restaurantID;
    private String restaurantName;
    private String restaurantNumber;
    private String restaurantAddress;
    private String restaurantService;
    private String restaurantIG;
    private String restaurantWebsite;
    private String restaurantCuisine;
    private String longitude;
    private String latitude;

    public Restaurant() {
    }


    public Restaurant(int restaurantID, String restaurantName, String restaurantNumber, String restaurantAddress,
                      String restaurantService, String restaurantIG, String restaurantWebsite, String restaurantCuisine, String latitude, String longitude) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.restaurantNumber = restaurantNumber;
        this.restaurantAddress = restaurantAddress;
        this.restaurantService = restaurantService;
        this.restaurantIG = restaurantIG;
        this.restaurantWebsite = restaurantWebsite;
        this.restaurantCuisine = restaurantCuisine;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantName(String name) {
        this.restaurantName = name;
    }
    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantNumber(String restaurantNumber) {
        this.restaurantNumber = restaurantNumber;
    }
    public String getRestaurantNumber() {
        return this.restaurantNumber;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }
    public String getRestaurantAddress() {
        return this.restaurantAddress;
    }

    public void setRestaurantService(String restaurantService) {
        this.restaurantService = restaurantService;
    }
    public String getRestaurantService() {
        return this.restaurantService;
    }

    public void setRestaurantIG(String restaurantIG) {
        this.restaurantIG = restaurantIG;
    }
    public String getRestaurantIG() {
        return this.restaurantIG;
    }

    public void setRestaurantWebsite(String restaurantWebsite) {
        this.restaurantWebsite = restaurantWebsite;
    }
    public String getRestaurantWebsite() {
        return this.restaurantWebsite;
    }

    public void setRestaurantCuisine(String restaurantCuisine) {
        this.restaurantCuisine = restaurantCuisine;
    }
    public String getRestaurantCuisine() {
        return this.restaurantCuisine;
    }

    public void setRestaurantLat(String latitude) {
        this.latitude = latitude;
    }
    public String getRestaurantLat() {
        return this.latitude;
    }

    public void setRestaurantLong(String longitude) {
        this.longitude = longitude;
    }
    public String getRestaurantLong() {
        return this.longitude;
    }

}
