package com.example.nstorflores.musicalizza;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.nstorflores.musicalizza.Activities.PrefManager;
import com.example.nstorflores.musicalizza.Activities.SignInActivity;
import com.tumblr.remember.Remember;

public class SplashScreen extends AppCompatActivity{

    public void validarSesion (){
        if (Remember.getString("access_token", "").isEmpty()){
            Intent intent = new Intent(SplashScreen.this, SignInActivity.class);
            startActivity(intent);

        }
        else {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private PrefManager prefManager;

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(true);

        startActivity(new Intent(SplashScreen.this, MainActivity.class));
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                prefManager = new PrefManager(SplashScreen.this);
                if (!prefManager.isFirstTimeLaunch()) {
                    launchHomeScreen();
                    finish();
                }else{
                    validarSesion();

                }

            }
        }, 3000);

    }
}
