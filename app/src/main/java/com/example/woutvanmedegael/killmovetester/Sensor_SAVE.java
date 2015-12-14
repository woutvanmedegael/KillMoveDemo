package com.example.woutvanmedegael.killmovetester;

import android.util.Log;

public class Sensor_SAVE extends SensorActor{
    private float licht;
    private float currentaccelero =0;
    private float maxNormAccelero =0;
    private float maxXgyro = 0;
    private float currentgyro = 0;

    public float getMaxNormAccelero() {
        return maxNormAccelero;
    }

    public float currentaccelero() {
        return currentaccelero;
    }

    public float getCurrentgyro(){return currentgyro;}

    public float getMaxXgyro() {
        return maxXgyro;
    }

    public float getLicht() {
        return licht;
    }

    public void Verwerk_Accelerometer(float x, float y, float z, float timenu) {
        float norm = (float) Math.sqrt(x * x + y * y + z * z);
        currentaccelero = norm;
        if (Math.abs(norm) > Math.abs(maxNormAccelero)) {
            maxNormAccelero = Math.abs(norm);
            Log.i("newmaxX", String.valueOf(maxNormAccelero));
        }
    }

    public void Verwerk_Gyroscoop(float x, float y, float z, float timenu) {
        currentgyro = x;
        if (Math.abs(x) > Math.abs(maxXgyro)) {
            maxXgyro = Math.abs(x);
        }
    }

    public void Verwerk_licht(float x, float timenu) {
        licht=x;
    }
}
