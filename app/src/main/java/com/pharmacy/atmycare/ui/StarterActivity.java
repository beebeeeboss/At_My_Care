package com.pharmacy.atmycare.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;


import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.pharmacy.atmycare.Database;
import com.pharmacy.atmycare.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StarterActivity extends AppCompatActivity  {

    private static Connection c = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Database db = new Database();
                c = db.getExtraConnection();
                while (c == null)
                    c = db.getExtraConnection();
            }
        };
        Thread thread = new Thread(r);
        thread.start();

        // Add this line, to include the Auth plugin.
        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.configure(getApplicationContext());
        } catch (AmplifyException e) {
            e.printStackTrace();
        }
    }
    public static Connection takeConnection()
    {
        if(c == null)
            return null;
        return c;
    }
}