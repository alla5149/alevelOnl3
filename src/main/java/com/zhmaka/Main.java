package com.zhmaka;

import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.service.CarService;
import com.zhmaka.util.RandomGenerator;

public class Main {

    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        RandomGenerator randomGenerator = new RandomGenerator();
        // Car secondCar = carService.create();
        //Car thirdCar = carService.create();
        //carService.check(firstCar);
        //carService.check(secondCar);
        // carService.check(thirdCar);
        carService.create(randomGenerator);
        //carService.printAll(cars);
        // carService.insert(1, firstCar);
        //carService.printAll(cars);
    }
}