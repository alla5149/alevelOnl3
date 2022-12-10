package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PassengerCar extends Car implements CountRestore{
    private int passengerCaunt;
    public PassengerCar() {
        super(Type.CAR);
    }

    public PassengerCar(final Color color){
        super(color, Type.CAR);

    }
    public PassengerCar(final Color color, final int passengerCaunt){
        super(color, Type.CAR);
        this.passengerCaunt = passengerCaunt;
    }
    @Override
    public int restore(){
        return passengerCaunt = 100;
    }

    @Override
    public String toString() {
        return super.toString() + " " + passengerCaunt;
    }
}