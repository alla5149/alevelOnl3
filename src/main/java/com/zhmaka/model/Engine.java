package com.zhmaka.model;

import java.util.Random;

public class Engine {
    private int power;
    private String type;

    public Engine(String type) {
        this.power = new Random().nextInt(1000);
        this.type = type;
    }
    public void setPower(int power){
        this.power = power;
    }
    public void getPower(){
        this.power = power;
    }
    public void setType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
