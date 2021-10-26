package com.pharmacy.atmycare.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;


import com.pharmacy.atmycare.R;

public class StarterActivity extends AppCompatActivity  {


    public static String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        checkForLoggedInUser();

    }
    private void checkForLoggedInUser()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
        if(sharedPreferences != null)
        {
            String type = sharedPreferences.getString("type","null");
            if(!type.equals("null"))
            {
                this.type = type;
            }
        }
    }
}