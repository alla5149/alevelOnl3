package com.zhmaka.container;

import com.zhmaka.model.Car;
import com.zhmaka.service.CarService;

import java.util.Random;

public class GenericContainer <T extends Car>{
    public static CarService carService = CarService.getInstance();
    public static final Random random = new Random();
    public final T t;

    public GenericContainer(T t){
        this.t = t;
    }

    public void print(T t){
        carService.printInfo(t);
    }

    public void increaseCount(){
        t.setCount(t.getCount() + random.nextInt(200)+100);
    }

    




}
