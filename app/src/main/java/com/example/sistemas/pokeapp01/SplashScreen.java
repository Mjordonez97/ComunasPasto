package com.example.sistemas.pokeapp01;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.sistemas.DatosColombia.MainActivity;
import com.example.sistemas.DatosColombia.R;
import com.example.sistemas.DatosColombia.models.Adaptador;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);

            }
        },3800);

    }
}
