package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class Car {
    private final String id;
    private String manufacturer;
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    public Car() {
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