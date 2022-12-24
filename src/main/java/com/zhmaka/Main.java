package com.zhmaka;

import com.zhmaka.container.CarList;
import com.zhmaka.model.Car;
import com.zhmaka.model.Type;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.service.CarService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(final String[] args){
        CarService carService = new CarService(new CarArrayRepository());
        CarList<Car> carList = new CarList<>();
        carList.addFirst(carService.createCar(Type.CAR));
        carList.addLast(carService.createCar(Type.CAR));
        carList.getIndex(carService.createCar(Type.CAR));
        carList.insertIndex(0, carService.createCar(Type.CAR));
        System.out.println(carList.size());
        carList.printNode();
        System.out.println(carList.getCount());






//        CarService carService = CarService.getInstance();
//        GenericContainer genericContainer = new GenericContainer<>(CarService.getInstance().createCar(Type.CAR));
//        genericContainer.increaseCount();
//        genericContainer.print(genericContainer.t);
//        genericContainer.increaseCount(10, genericContainer.t);
//        genericContainer.print(genericContainer.t);

//        carService.create(8);
//        carService.printAll();
//
//
//        Car[] cars = carService.getAll();
//        Car car1 = cars[1];
//        Car car2 = cars[2];
//        System.out.println(AlgorithmUtil.binarySearch(cars,car1));
//        System.out.println(AlgorithmUtil.bubbleSort(cars));
//
//
//        final Actions[] values = Actions.values();
//        final String[] names = mapActionToName(values);
//
//        while (true) {
//            final int userInput = UserInput.menu(names);
//            Actions.values()[userInput].execute();
//        }
//
//
//

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