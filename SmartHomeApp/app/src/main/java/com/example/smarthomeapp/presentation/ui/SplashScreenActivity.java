package com.example.smarthomeapp.presentation.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.smarthomeapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        /* New Handler to start the Menu-Activity
//         * and close this Splash-Screen after some seconds.
//         * */
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                Intent mainIntent;
//
//                // TODO: 29/03/2017 create home/divisions activity
//                mainIntent = new Intent(SplashScreenActivity.this, NextActivity.class);
//
//                /* Create an Intent that will start the Home Activity. */
//                SplashScreenActivity.this.startActivity(mainIntent);
//
//                SplashScreenActivity.this.finish();
//            }
//        }, SPLASH_DISPLAY_LENGTH);
    }
}
