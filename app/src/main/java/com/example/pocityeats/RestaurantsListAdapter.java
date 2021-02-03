package com.example.pocityeats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RestaurantsListAdapter extends ArrayAdapter<Restaurant> {
    // loads restaurant details into restaurants.xml textview
    // takes info from columns and puts it into corresponding textviews

    Context context;
    private ArrayList<Restaurant> restaurants;

    public RestaurantsListAdapter(Context context, int textViewResourceId, ArrayList<Restaurant> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.restaurants = items;
    }

//    @NonNull
//    @Override
//    public static Context getContext() {
//        return super.getContext();
//    }

    @Override
    public View getView(int index, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.restaurants, null);
        }
        Restaurant i = restaurants.get(index);
        if (i != null) {
//            TextView id = (TextView) v.findViewById(R.id.index);
//            id.setText(String.valueOf(i.getRestaurantID()));

            TextView name = (TextView) v.findViewById(R.id.name);
            name.setText(String.valueOf(i.getRestaurantName()));

//            TextView number = (TextView) v.findViewById(R.id.number);
//            number.setText(String.valueOf(i.getRestaurantNumber()));
//
//            TextView address = (TextView) v.findViewById(R.id.address);
//            address.setText(String.valueOf(i.getRestaurantAddress()));

            TextView service = (TextView) v.findViewById(R.id.service);
            service.setText(String.valueOf(i.getRestaurantService()));

//            TextView ig = (TextView) v.findViewById(R.id.ig);
//            ig.setText(String.valueOf(i.getRestaurantIG()));
//
//            TextView website = (TextView) v.findViewById(R.id.website);
//            website.setText(String.valueOf(i.getRestaurantWebsite()));

            TextView cuisine = (TextView) v.findViewById(R.id.cuisine);
            cuisine.setText(String.valueOf(i.getRestaurantCuisine()));

        }
        return v;
    }

    public void clearData() {
        // clear the data
        restaurants.clear();
    }
}
