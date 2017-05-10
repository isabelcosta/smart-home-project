package com.example.smarthomeapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.smarthomeapp.login.LoginActivity;
import com.example.smarthomeapp.util.Constants;
import com.example.smarthomeapp.util.SharedPreferencesUtils;

public class SplashScreenActivity extends BaseActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set to FullScreen Mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        // Hide Action Bar
        getSupportActionBar().hide();

//        setContentView(R.layout.activity_splash_screen);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.
         * */
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent;

                mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
//                if(SharedPreferencesUtils.getBooleanPreference(getBaseContext(), Constants.Login.IS_LOGGED, false)){
//                } else {
//                    mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
//                }

                // TODO: 30/03/2017 for test purposes
//                Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);

                /* Create an Intent that will start the Home Activity. */
                SplashScreenActivity.this.startActivity(mainIntent);

                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash_screen;
    }
}
