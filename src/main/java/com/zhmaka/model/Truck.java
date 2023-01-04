package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Truck extends Car implements CountRestore {
    private int loadCapacity;

    public Truck(Manufacturer manufacturer, Color color, Engine engine) {
        super(Type.TRUCK);
    }

    public Truck(final Color color) {
        super(color, Type.TRUCK);
    }

    public Truck(Color color, int loadCapacity) {
        super(color, Type.TRUCK);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + " " + loadCapacity;
    }

    @Override
    public int restore() {
        return this.loadCapacity = 50;
    }
}