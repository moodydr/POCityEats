package com.example.pocityeats;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RestaurantDetails extends AppCompatActivity {

    TextView restaurantName;
    TextView restaurantAddress;
    TextView restaurantNumber;
    TextView restaurantService;
    TextView restaurantIG;
    TextView restaurantWebsite;
    TextView restaurantCuisine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        if (savedInstanceState == null) {
            Bundle details = getIntent().getExtras();
            String name;
            String address;
            String number;
            String service;
            String ig;
            String website;
            String cuisine;
            if(details == null) {
                name = null;
                address = null;
                number = null;
                service = null;
                ig = null;
                website = null;
                cuisine = null;
            } else {
                name = (String) details.get(MainActivity.RESTAURANT_CHOICE_NAME);
                restaurantName = this.findViewById(R.id.popup_name);
                restaurantName.setText(name);

                address = (String) details.get(MainActivity.RESTAURANT_CHOICE_ADDRESS);
                restaurantAddress = this.findViewById(R.id.popup_address);
                restaurantAddress.setText(address);

                number = (String) details.get(MainActivity.RESTAURANT_CHOICE_NUMBER);
                restaurantNumber = this.findViewById(R.id.popup_phone);
                restaurantNumber.setText(number);

                service = (String) details.get(MainActivity.RESTAURANT_CHOICE_SERVICE);
                restaurantService = this.findViewById(R.id.popup_service);
                restaurantService.setText(service);

                ig = (String) details.get(MainActivity.RESTAURANT_CHOICE_IG);
                restaurantIG = this.findViewById(R.id.popup_instagram);
                restaurantIG.setText(ig);

                website = (String) details.get(MainActivity.RESTAURANT_CHOICE_WEBSITE);
                restaurantWebsite = this.findViewById(R.id.popup_website);
                restaurantWebsite.setText(website);

                cuisine = (String) details.get(MainActivity.RESTAURANT_CHOICE_CUISINE);
                restaurantCuisine = this.findViewById(R.id.popup_cuisine);
                restaurantCuisine.setText(cuisine);

            }
        }
    }


}