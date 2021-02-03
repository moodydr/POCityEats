package com.example.pocityeats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONObject;

public class LoadingScreen extends AppCompatActivity {
    MainActivity main = new MainActivity();
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        btnDownload = (Button) findViewById(R.id.btnDownload);
    }

    public void startMain(View view) {
        Intent intent = new Intent(LoadingScreen.this, MainActivity.class);
        startActivity(intent);
    }
}