package com.example.pocityeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    TextView search_input;
    public static final String RESTAURANT_CHOICE_NAME = "com.example.pocityeats.NAME";
    public static final String RESTAURANT_CHOICE_ADDRESS = "com.example.pocityeats.ADDRESS";
    public static final String RESTAURANT_CHOICE_NUMBER = "com.example.pocityeats.NUMBER";
    public static final String RESTAURANT_CHOICE_SERVICE = "com.example.pocityeats.SERVICE";
    public static final String RESTAURANT_CHOICE_IG = "com.example.pocityeats.IG";
    public static final String RESTAURANT_CHOICE_WEBSITE = "com.example.pocityeats.WEBSITE";
    public static final String RESTAURANT_CHOICE_CUISINE = "com.example.pocityeats.CUISINE";

    public ListView listview;

    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    static ArrayList<Restaurant> search_results = new ArrayList<>();
    RestaurantsListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_input = (EditText) findViewById(R.id.search_input);
        search_input.setImeOptions(EditorInfo.IME_ACTION_DONE);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_map_view) {
                    Intent openMapsIntent = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(openMapsIntent);

                    return true;
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_list_view);

        listview = (ListView) findViewById(R.id.listview);
        new DownloadGoogleSheetTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                processJson(object);
            }
        }).execute("https://spreadsheets.google.com/tq?key=1vOsOI5D5hPvrnxpSURR524Za2vIG0l53aBlA-tbPttM");
        // 1SXG4C3NUYHwJjI_HuEQLz-IUSYgP_4bTwwF8CCzL0TM - google sheet key
        // 1KIT8WtTix-BR2cZAIMMMExWQcvODhhAwGfTBx3QZ_E8 - test sheet
        // 1vOsOI5D5hPvrnxpSURR524Za2vIG0l53aBlA-tbPttM


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {

                Intent openRestaurantDetailsIntent = new Intent(MainActivity.this, RestaurantDetails.class);
                Restaurant r = search_results.get(position);

                openRestaurantDetailsIntent.putExtra(RESTAURANT_CHOICE_NAME, r.getRestaurantName());
                openRestaurantDetailsIntent.putExtra(RESTAURANT_CHOICE_ADDRESS, r.getRestaurantAddress());
                openRestaurantDetailsIntent.putExtra(RESTAURANT_CHOICE_NUMBER, r.getRestaurantNumber());
                openRestaurantDetailsIntent.putExtra(RESTAURANT_CHOICE_SERVICE, r.getRestaurantService());
                openRestaurantDetailsIntent.putExtra(RESTAURANT_CHOICE_IG, r.getRestaurantIG());
                openRestaurantDetailsIntent.putExtra(RESTAURANT_CHOICE_WEBSITE, r.getRestaurantWebsite());
                openRestaurantDetailsIntent.putExtra(RESTAURANT_CHOICE_CUISINE, r.getRestaurantCuisine());

                startActivity(openRestaurantDetailsIntent);
            }
        });
    }


    public void processJson(JSONObject object) {
        restaurants.clear();
        search_results.clear();
        try {
            JSONArray rows = object.getJSONArray("rows");

            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

                int index = columns.getJSONObject(0).getInt("v");
                String name = columns.getJSONObject(1).getString("v");
                String number = columns.getJSONObject(2).getString("v");
                String address = columns.getJSONObject(3).getString("v");
                String service = columns.getJSONObject(4).getString("v");
                String IG = columns.getJSONObject(5).getString("v");
                String website = columns.getJSONObject(6).getString("v");
                String cuisine = columns.getJSONObject(7).getString("v");
                String latitude = columns.getJSONObject(8).getString("v");
                String longitude = columns.getJSONObject(9).getString("v");

                Restaurant restaurant = new Restaurant(index, name, number, address,
                        service, IG, website, cuisine, latitude, longitude);
                restaurants.add(restaurant); // array to look from each time we search
                search_results.add(restaurant); // actual array to inflate in listview onCreate and
                                                // each time we search
            }
            adapter = new RestaurantsListAdapter(this, R.layout.restaurants, search_results);
            listview.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void buttonClickHandler(View view) {
        //make another listview for restaurant search
        //if search == null
        search_results.clear();
        search_input.setImeOptions(EditorInfo.IME_ACTION_DONE);
        if (search_input.getText().equals("")){
            search_results.addAll(restaurants);
        }
        for (Restaurant r: restaurants) {
            if (r.getRestaurantName().toLowerCase().contains(search_input.getText().toString().toLowerCase())){
                search_results.add(r);
            }
        }
        adapter = new RestaurantsListAdapter(this, R.layout.restaurants, search_results);
        listview.setAdapter(adapter);

    }

}