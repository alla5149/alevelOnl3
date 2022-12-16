package com.zhmaka;

import com.zhmaka.action.Actions;
import com.zhmaka.service.CarService;
import com.zhmaka.util.UserInput;

import static com.zhmaka.action.Actions.mapActionToName;

public class Main {
    public static void main(final String[] args){

        CarService carService = CarService.getInstance();
        carService.create(9);
        carService.printAll();



//        Car [] cars = carService.getAll();
//        Car car1 = cars[1];
//        Car car2 = cars[2];




        final Actions[] values = Actions.values();
        final String[] names = mapActionToName(values);

        while (true) {
            final int userInput = UserInput.menu(names);
            Actions.values()[userInput].execute();
        }




//            CarService carService = new CarService(new CarArrayRepository());
//            RandomGenerator randomGenerator = new RandomGenerator();
//            final Car newCar = carService.createCar(Type.CAR);
//            carService.print(newCar);
//
//            carService.printManufacturerAndCount(newCar);
//
//            carService.printColor(newCar);
//
//            newCar.setCount(11);
//            carService.checkCount(newCar);
//
//            carService.printEngineInfo(newCar);
//
//            carService.printInfo(newCar);


//            final PassengerCar passengerCar = (PassengerCar) carService.createCar(Type.CAR);
//            final Truck truck = (Truck) carService.createCar(Type.TRUCK);
//            carService.print(passengerCar);
//            carService.print(truck);
//            System.out.println();
//            System.out.println(passengerCar);
//            System.out.println(truck);
}
        }