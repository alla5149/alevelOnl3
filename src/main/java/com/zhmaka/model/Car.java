package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public abstract class Car implements CountRestore{
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private Type type;
    private int count;
    private int price;

    public Car(String manufacturer, Engine engine, Color color) {
        this.manufacturer = this.manufacturer;
        this.engine = this.engine;
        this.color = this.color;
        this.type = type;
        this.count = 1;
        id = UUID.randomUUID().toString();
        price = new Random().nextInt(10000);
    }

    public Car(){
        this.id = UUID.randomUUID().toString();
        this.count = 1;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Manufacturer: %s, Engine: %s, Color: %s, Count; %s, Price; %s%n",
                id, manufacturer, engine, color, count, price);
    }

    ///
}