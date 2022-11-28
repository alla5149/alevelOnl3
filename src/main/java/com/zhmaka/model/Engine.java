package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Engine {
    final private Random random = new Random();
    private int power;
    private String type;

    public Engine(){
    }

    public Engine(String type) {
        this.power = new Random().nextInt(1000);
        this.type = type;
    }

}