package com.example.woutvanmedegael.killmovetester;



public class myFirstKillMove extends KillMoveSensors {
    @Override
    public int killtime() {
        return 20000;
    }

    @Override
    public String moveinfo() {
        return "accelerate";
    }

    @Override
    public void KillMove() {
        MapsActivity.setCurrentValue(Float.toString(getAccel()));
        if (getMaxAccel()>20){
            finishKillMove(true);
        }
    }
}
