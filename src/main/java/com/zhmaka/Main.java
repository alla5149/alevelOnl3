package com.zhmaka;

import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.service.CarService;
import com.zhmaka.util.RandomGenerator;

public class Main {

    public static void main(String[] args) {
        CarService carService = new CarService(new CarArrayRepository());
        RandomGenerator randomGenerator = new RandomGenerator();
        carService.createPassengerCar();
        carService.createTruck();
        carService.print(carService.createTruck());
        carService.print(carService.createPassengerCar());
    }
}