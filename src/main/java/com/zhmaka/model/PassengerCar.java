package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PassengerCar extends Car implements CountRestore{
    private int passengerCaunt;

    public PassengerCar(){

    }
    public PassengerCar(String id, String manufacturer, Engine engine, Color color, int passengerCaunt ){
        super(manufacturer, engine, color);
        this.passengerCaunt = passengerCaunt;
    }

    @Override
    public int restore(){
        return passengerCaunt = 100;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Manufacturer: %s, Engine: %s, Color: %s, passengerCaunt: %s, Type: %s, %s%n",
                getId(), getManufacturer(),getEngine(), getColor(),getPassengerCaunt(), getType());
    }


}
