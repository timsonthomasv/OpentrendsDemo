/*
* ===========================================================================
* Copyright 2016 OpenTrends
* All Rights Reserved
* ===========================================================================
*
* File Name: Splash.java
*
*
* Version Number: 0.0.0.1
*
* Created Date: 15 Mar 2016
*
*/
package com.opentrends.demo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.opentrends.demo.R;

public class Splash extends Activity {

    // Set the splash screen time out in milliseconds
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /**
         * Create handler to manage time out delay of 2 seconds
         */
        new Handler().postDelayed(new Runnable() {

            /*
             * Run splash screen delay with a timer.
             */
            @Override
            public void run() {
                // The run method will be called when the activity is
                //called.
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }


}
