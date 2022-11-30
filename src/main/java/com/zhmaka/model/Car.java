package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public abstract class Car implements CountRestore {
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    public Car(String manufacturer, Engine engine, Color color) {
        id = UUID.randomUUID().toString();
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        price = new Random().nextInt(10000);

    }
    @Override
    public String toString() {
        return String.format("ID: %s, Manufacturer: %s, Engine: %s, Color: %s, Count; %s, Price; %s%n",
                id, manufacturer, engine, color, count, price);
    }
}