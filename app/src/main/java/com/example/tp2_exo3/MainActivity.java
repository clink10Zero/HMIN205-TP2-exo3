package com.example.tp2_exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.linearLayout = findViewById(R.id.linearLayout);

        final SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, acc, sensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            double accel = Math.abs(event.values[0]) + Math.abs(event.values[1]) + Math.abs(event.values[2]);
            if(accel < 12) {
                this.linearLayout.setBackgroundColor(Color.GREEN);
            }
            else if (accel < 15) {
                this.linearLayout.setBackgroundColor(Color.BLACK);
            }
            else {
                this.linearLayout.setBackgroundColor(Color.RED);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}