package com.zhmaka.model;

import java.util.Random;

public class Engine {
    private int power;
    private String type;

    public Engine(){
    }

    public Engine(String type) {
        this.power = new Random().nextInt(1000);
        this.type = type;
    }
    public int setPower(int power){
        return power;
    }
    public int getPower(){
        return power;
    }
    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}