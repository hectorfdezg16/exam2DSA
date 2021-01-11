package com.example.mycustomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //creamos thread para que aparezca durante un periodo de tiempo
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                //hacemos un intent para llevarlo despúes al main donde le pedirá nombre usuario
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                //cerramos splash screen con logo android dentro
                finish();
            }
            //ponemos 3 segundos de espera
        }, 3000);
    }
}