package com.pharmacy.atmycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import com.pharmacy.atmycare.ui.StarterActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView mImageView;
    private static boolean isUserFirstTimeOpenApp = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mImageView = findViewById(R.id.ivSplash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES:
                mImageView.setImageResource(R.drawable.logo_white);
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                break;
        }

        if(isUserFirstTimeOpenApp)
        {
            isUserFirstTimeOpenApp = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this , StarterActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            },2000);
        }
        //hello
        else
        {
            Intent intent = new Intent(SplashActivity.this , StarterActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}