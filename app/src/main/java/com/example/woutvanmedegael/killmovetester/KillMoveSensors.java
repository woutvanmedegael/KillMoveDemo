package com.example.woutvanmedegael.killmovetester;

import android.os.CountDownTimer;

public abstract class KillMoveSensors {
    public Sensor_SAVE sensorsave;
    public SensorCollector sensorcol;
    public CountDownTimer myCountDownTimer;
    public abstract int killtime();
    public abstract String moveinfo();

    public abstract void KillMove();

    public void Countdown(){
        MapsActivity.TextsVisible(true);
        MapsActivity.setInfoKillMove(moveinfo());
        myCountDownTimer = new CountDownTimer(killtime(),200) {
            @Override
            public void onTick(long millisUntilFinished) {
                MapsActivity.setKillMoveSeconds(Long.toString(millisUntilFinished/1000));
                KillMove();
            }

            @Override
            public void onFinish() {
                finishKillMove(false);
            }
        };
        myCountDownTimer.start();
    }

    public void startkillmove(){
        sensorsave = new Sensor_SAVE();
        sensorcol = new SensorCollector(sensorsave);
        sensorcol.start(MapsActivity.getContext());
        Countdown();
    }

    public void finishKillMove(Boolean success){
        try{
            myCountDownTimer.cancel();
        } catch (Exception e){
            e.printStackTrace();
        }
        sensorcol.stop();
        MapsActivity.endkillmove(success);
    }

    public float getMaxAccel(){
        return sensorsave.getMaxNormAccelero();
    }

    public float getLight(){
        return sensorsave.getLicht();
    }

    public float getMaxGyro(){
        return sensorsave.getMaxXgyro();
    }

    public float getAccel(){
        return sensorsave.currentaccelero();
    }

    public float getGyro(){
        return sensorsave.getCurrentgyro();
    }
}
