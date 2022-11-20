package com.zhmaka;

import com.zhmaka.model.Car;
import com.zhmaka.service.CarService;

public class Main {

    public static void main(String[] args) {
        Car car1 = CarService.create();
        Car car2 = CarService.create();
        Car car3 = CarService.create();
        CarService.print(car1, car2, car3);

    }
}
