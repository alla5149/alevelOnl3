package com.zhmaka;

import com.zhmaka.model.PassengerCar;
import com.zhmaka.model.Truck;
import com.zhmaka.model.Type;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.service.CarService;
import com.zhmaka.util.RandomGenerator;

public class Main {
        public static void main(String[] args) {
            CarService carService = new CarService(new CarArrayRepository());
            RandomGenerator randomGenerator = new RandomGenerator();
            final PassengerCar passengerCar = (PassengerCar) carService.createCar(Type.CAR);
            final Truck truck = (Truck) carService.createCar(Type.TRUCK);
            carService.print(passengerCar);
            carService.print(truck);
            System.out.println();
            System.out.println(passengerCar);
            System.out.println(truck);

        }
    }