package com.zhmaka.service;

import com.zhmaka.model.Car;

import java.util.Random;

public class CarService {
    public static Car create() {
        return new Car(randomString(), randomString(), randomString());
    }
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private static String randomString() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return null;
    }

    public static void print(Car... cars) {
        for (Car car : cars) {
            System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d%n",
                    car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
        }
    }
}

