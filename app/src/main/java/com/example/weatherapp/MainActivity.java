package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //class member variables
    Button btn_getCityId, btn_getWeatherById, btn_getWeatherByName;
    ListView lv_weatherReports;
    EditText et_dataInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning values to each control on the layout
        btn_getCityId = findViewById(R.id.btn_getCityId);
        btn_getWeatherById = findViewById(R.id.btn_getWeatherById);
        btn_getWeatherByName = findViewById(R.id.btn_getWeatherByName);

        et_dataInput = findViewById(R.id.et_dataInput);

        lv_weatherReports = findViewById(R.id.lv_weatherReport);

        //click listeners for each button
        btn_getCityId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we create events to check when the button is clicked
                Toast.makeText(MainActivity.this, "Hi, you need something?", Toast.LENGTH_SHORT).show();
            }
        });

        btn_getWeatherById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });

        btn_getWeatherByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });

    }
}