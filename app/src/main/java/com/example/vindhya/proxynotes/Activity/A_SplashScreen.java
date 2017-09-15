package com.example.vindhya.proxynotes.Activity;

/**
 * Created by VINDHYA on 12-Sep-17.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.vindhya.proxynotes.R;

public class A_SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.a_splash_activity);

        //creating thread that will sleep for 10 seconds
        Thread t = new Thread() {
            public void run() {

                try {
                    //sleep thread for 10 seconds, time in milliseconds
                    sleep(2000);

                    //start new activity
                    Intent i = new Intent(A_SplashScreen.this, B_HomeActivity.class);
                    startActivity(i);

                    //destroying Splash activity
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //start thread
        t.start();
    }
}