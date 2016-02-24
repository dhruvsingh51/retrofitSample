package com.example.techjini.retrofitsample1;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.test.suitebuilder.TestMethod;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import apicall.APIBuilder;
import apicall.MyApiEndpointInterface;
import modle.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import utility.Constants;

public class MainActivity extends Activity {

    private Retrofit mRetrofit;
    private TextView timeDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeDisplay = (TextView) findViewById(R.id.time_display);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                mRetrofit = APIBuilder.retrofitBuilder();

                MyApiEndpointInterface apiService =
                        mRetrofit.create(MyApiEndpointInterface.class);

                Call<User> call = apiService.getUser(Constants.USERNAME, Constants.APP_KEY, Constants.API_KEY);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        int statusCode = response.code();
                        if (statusCode == 200) {
                        }
                        User user = response.body();
                        Snackbar.make(view, "Response recieved", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        // Log error here since request failed
                        Snackbar.make(view, "Fail", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
