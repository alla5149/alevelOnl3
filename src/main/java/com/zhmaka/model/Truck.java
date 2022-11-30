package com.zhmaka.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Truck extends Car implements CountRestore{
    private int loadCapacity;

    public Truck(){
    }


}
