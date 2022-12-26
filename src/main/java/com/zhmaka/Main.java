package com.zhmaka;

import com.zhmaka.container.CarComparator;
import com.zhmaka.container.CarTree;
import com.zhmaka.model.Car;
import com.zhmaka.model.Type;
import com.zhmaka.service.CarService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(final String[] args){
        CarService carService = CarService.getInstance();
        Car car1 = carService.createCar(Type.CAR);
        Car car2 = carService.createCar(Type.CAR);
        Car car3 = carService.createCar(Type.CAR);
        Car car4 = carService.createCar(Type.CAR);
        Car car5 = carService.createCar(Type.CAR);
        Car car6 = carService.createCar(Type.CAR);

        System.out.println(car1.toString() + car2.toString() + car3.toString()
                + car4.toString() + car5.toString() +car6.toString());

        CarComparator<Car> carComparator = new CarComparator<>();
        System.out.println(carComparator.compare(carService.createCar(Type.CAR), carService.createCar(Type.CAR)));

        CarTree carTree = new CarTree<>();
        carTree.insertNode(car1);
        carTree.insertNode(car2);
        carTree.insertNode(car3);
        carTree.insertNode(car4);
        carTree.insertNode(car5);
        carTree.insertNode(car6);
        carTree.printTree();
        carTree.findNodeByValue(car1);
        carTree.findNodeByValue(car2);
        carTree.findNodeByValue(car3);
        carTree.findNodeByValue(car4);
        carTree.findNodeByValue(car5);
        carTree.findNodeByValue(car6);

        System.out.println("Count is :" + carTree.getCount());
















//        CarService carService = new CarService(new CarArrayRepository());
//        CarList<Car> carList = new CarList<>();
//        carList.addFirst(carService.createCar(Type.CAR));
//        carList.addLast(carService.createCar(Type.CAR));
//        carList.getIndex(carService.createCar(Type.CAR));
//        carList.insertIndex(0, carService.createCar(Type.CAR));
//        System.out.println(carList.size());
//        carList.printNode();
//        System.out.println(carList.getCount());
//
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