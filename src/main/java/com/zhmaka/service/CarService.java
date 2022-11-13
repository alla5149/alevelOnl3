package com.zhmaka.service;

import com.zhmaka.model.Car;
import com.zhmaka.model.Color;
import com.zhmaka.model.Engine;
import com.zhmaka.repository.CarArrayRepository;

import java.util.Arrays;
import java.util.Random;

public class CarService {
    private final CarArrayRepository carArrayRepository;

    private final Random random = new Random();

    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public Car create() {
        Engine engine = new Engine(getRandomString());
        Car car = new Car(getRandomString(), engine, getRandomColor());
        carArrayRepository.save(car);
        return car;
    }

    public void create(final int count) {
        for (int i = 0; i < count; i++) {
            create();
        }
    }

    public void insert(int index, final Car car) {
        if (index < 0 || car == null) {
            return;
        }
        carArrayRepository.insert(index, car);
    }

    public void print(Car car) {
        String carInfo = String.format("{ID: %s, Manufacturer: %s, EnginePower: %s, EngineType: %s, Color: %s, Count; %s, Price; %s}",
                car.getId(), car.getManufacturer(), car.getEnginePower(), car.getEngineType(), car.getColor(), car.getCount(), car.getPrice());
        System.out.println(carInfo);
    }

    public void check(Car car) {
        if (car.getCount() >= 1 && (car.getEnginePower() > 200)) {
            System.out.println("The car is completely ready for sale");
        } else if (car.getCount() < 1 && (car.getEnginePower() > 200)) {
            System.out.println("The count of the car = 0");
        } else if (car.getCount() >= 1 && (car.getEnginePower() <= 200)) {
            System.out.println("The engine power of the car is less than 200");
        } else {
            System.out.println("The count of the car = 0 and the engine power of the car is less than 200");
        }
    }

    private Color getRandomColor() {
        final Color[] values = Color.values();
        final int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    public void printAll() {
        final Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    public Car find(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }

    public void delete(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carArrayRepository.delete(id);
    }

    public void changeRandomColor(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        final Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        int length = random.nextInt(10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}