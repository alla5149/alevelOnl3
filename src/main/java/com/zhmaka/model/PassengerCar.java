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




}
