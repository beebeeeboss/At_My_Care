package com.pharmacy.atmycare.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;


import com.pharmacy.atmycare.Database;
import com.pharmacy.atmycare.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StarterActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Database db = new Database();
                Connection c = db.getExtraConnection();
                while (c == null)
                    c = db.getExtraConnection();
                takeConnection(c);
            }
        };
        Thread thread = new Thread(r);
        thread.start();

      }
    public Connection takeConnection(Connection c)
    {

        if(c != null)
        {
           return c;
        }
        else
        {
           return null;
        }
    }
}