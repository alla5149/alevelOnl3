package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
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

    public Car(Color color, Engine engine, Type type) {
        this.engine = this.engine;
        this.color = this.color;
        this.type = type;
        this.count = 1;
        id = UUID.randomUUID().toString();
        price = new Random().nextInt(10000);
    }

    public Car(Color color, Type type){
        this.manufacturer = getManufacturer();
        this.color = color;
        this.id = UUID.randomUUID().toString();
        this.count = 1;
        this.type = type;
    }

    public Car(Type type){
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", id, color);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return count == car.count && color == car.color && type.equals(car.type) && id.equals(car.id) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode(){
        return Objects.hash(count, color, type, id, engine);
    }



}