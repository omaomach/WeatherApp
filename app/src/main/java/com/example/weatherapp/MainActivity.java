package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        final WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this); // making an instance of the WeatherDataService class so as to get to its methods

        //click listeners for each button
        btn_getCityId.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //this doesn't work
                weatherDataService.getCityId(et_dataInput.getText().toString(), new WeatherDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String cityId) {
                        Toast.makeText(MainActivity.this, "Returned an ID of " + cityId, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        btn_getWeatherById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               weatherDataService.getCityForecastById("44418");

            }
        });

        btn_getWeatherByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You typed " + et_dataInput.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}