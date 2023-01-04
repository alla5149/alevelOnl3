package com.zhmaka;

import com.zhmaka.container.CarTree;
import com.zhmaka.model.Color;
import com.zhmaka.model.PassengerCar;
import com.zhmaka.model.Type;
import com.zhmaka.service.CarService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(final String[] args) {

        PassengerCar passengerCar1 = new PassengerCar();
        PassengerCar passengerCar2 = new PassengerCar();
        PassengerCar passengerCar3 = new PassengerCar();
        PassengerCar passengerCar4 = new PassengerCar();
        PassengerCar passengerCar5 = new PassengerCar();
        PassengerCar passengerCar6 = new PassengerCar();
        passengerCar1.setCount(6);
        passengerCar2.setCount(5);
        passengerCar3.setCount(4);
        passengerCar4.setCount(3);
        passengerCar5.setCount(2);
        passengerCar6.setCount(1);

        CarTree<PassengerCar> carTree = new CarTree<>(passengerCar1);
        carTree.insertNode(passengerCar1);
        carTree.insertNode(passengerCar2);
        carTree.insertNode(passengerCar3);
        carTree.insertNode(passengerCar4);
        carTree.insertNode(passengerCar5);
        carTree.insertNode(passengerCar6);

        carTree.printTree();


        Map<String, Object> map = new HashMap<>();
        map.put("count", 10);
        map.put("color", Color.GOLD);
        map.put("type", Type.CAR);
        map.put("passengerCount", 12);
        CarService carService = CarService.getInstance();

//        Car car = carService.mapToObject.apply(map);
//        System.out.println(car);

    }
}