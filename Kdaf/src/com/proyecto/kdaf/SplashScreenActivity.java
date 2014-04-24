package com.proyecto.kdaf;

import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class SplashScreenActivity extends Activity {

	// Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 5000;
    public static final String ARCHIVO_PREFS = "myPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash_screen);

     // creamos un editor para poder acceder a las shared preferences
        SharedPreferences settings = getSharedPreferences(ARCHIVO_PREFS, Context.MODE_PRIVATE);
        // comprobamos si existen los valores.
        final String username = settings.getString("username", null);
        final String password = settings.getString("password", null);
        
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

            	if ((username!=null) && (password!=null)){
            		// Start the next activity
                    Intent mainIntent = new Intent().setClass(
                            SplashScreenActivity.this, MenuActivity.class);
                    startActivity(mainIntent);
            	}else{
            		// Start the next activity
                    Intent mainIntent = new Intent().setClass(
                            SplashScreenActivity.this, Registro.class);
                    startActivity(mainIntent);
            	}
                

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
