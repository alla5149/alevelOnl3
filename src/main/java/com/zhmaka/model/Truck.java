package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Truck extends Car implements CountRestore {
    private int loadCapacity;

    public Truck() {
        super(Type.TRUCK);
    }

    public Truck(final Color color){
        super(color, Type.TRUCK);
    }

    public Truck(Color color, int loadCapacity){
        super(color, Type.TRUCK);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, ID: %s, Manufacturer: %s, Engine: %s, Color: %s, LoadCapacity: %s, %s%n",
                getType(), getId(), getManufacturer(), getEngine(), getColor(), getLoadCapacity());
    }

    @Override
    public int restore() {
        return this.loadCapacity = 50;
    }
}


