package com.example.weatherapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";
    public static final String QUERY_FOR_CITY_WEATHER_BY_ID = "https://www.metaweather.com/api/location/";

    String cityId;

    Context context;
    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String cityId);
    }

    public void getCityId(String cityName, VolleyResponseListener volleyResponseListener) {
        String url = QUERY_FOR_CITY_ID + cityName;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //we are get the entire array the getting one piece of the array i.e the first item
                        cityId = "";
                        try {
                            JSONObject cityInfo = response.getJSONObject(0);
                            cityId = cityInfo.getString("woeid");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //this works but never returned id to MainActivity
                        Toast.makeText(context, "City Id = " + cityId, Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onResponse(cityId);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context, "Something wrong happened", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Something went wrong");

            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

        //return cityId; // returned a null. error

    }

    public void getCityForecastById (String cityId) {
        List<WeatherReportsModel> report = new ArrayList<>();
        //get JSON object
        String url = QUERY_FOR_CITY_ID + cityId;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

                //get the property called "consolidated weather" which is an array

                //get each item in the array and assign it to a new WeatherReportModel object

    }

//    public list<WeatherReportsModel> getCityForecastByName (String cityName) {
//
//    }

}
