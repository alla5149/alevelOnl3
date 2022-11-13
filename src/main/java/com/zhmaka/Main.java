package com.zhmaka;

import com.zhmaka.model.Car;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.service.CarService;

public class Main {

    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        Car firstCar = carService.create();
        Car secondCar = carService.create();
        Car thirdCar = carService.create();
        carService.check(firstCar);
        carService.check(secondCar);
        carService.check(thirdCar);
        carService.create(3);
        carService.printAll();
        carService.insert(1, firstCar);
        carService.printAll();
    }
}