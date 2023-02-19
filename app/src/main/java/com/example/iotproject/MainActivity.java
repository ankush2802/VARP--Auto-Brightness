package com.example.iotproject;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.io.IOException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtAppName;
    ConstraintLayout constraintLayout;

    Animation txtAnimation, layoutAnimation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_to_top);

        txtAppName = findViewById(R.id.appName);
        constraintLayout = findViewById(R.id.conMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                constraintLayout.setVisibility(View.VISIBLE);
                constraintLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtAppName.setVisibility(View.VISIBLE);
                        txtAppName.setAnimation(txtAnimation);
                    }
                }, 900);
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        }, 6000);
    }
}