package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Truck extends Car implements CountRestore{
    private int loadCapacity;

    public Truck(){
    }

    public int Truck(String id, String manufacturer, Engine engine, Color color, int loadCapacity){
        super(manufacturer, engine, color);
        return this.loadCapacity = 50;
    }
@Override
public String toString() {
    return String.format("ID: %s, Manufacturer: %s, Engine: %s, Color: %s, LoadCapacity: %s, Type: %s, %s%n",
            getId(), getManufacturer(),getEngine(), getColor(),getLoadCapacity(), getType());
}
}


