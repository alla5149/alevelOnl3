package com.zhmaka.repository;

import com.zhmaka.model.Car;
import com.zhmaka.model.Color;

public class CarArrayRepository implements InterfaceForRepository <Car>{
    private static Car[] cars = new Car[10];
    public static CarArrayRepository carArrayRepository;
    public CarArrayRepository() {
    }

    public static CarArrayRepository getInstance(){
        cars = new Car[10];
        if (carArrayRepository == null){
            return new CarArrayRepository();
        }
        return carArrayRepository;
    }

    @Override
    public void save(final Car car) {
        if (car == null) {
            return;
        }
        int index = putCar(car);
        if (index == cars.length){
            int oldLength = cars.length;
            increaseArray();
            cars[oldLength] = car;
        }
    }


    private int putCar(Car car) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index] == null) {
                cars[index] = car;
                break;
            }
        }
        return index;
    }

    @Override
    public Car[] getAll() {
        final int newLength = foundLength();
        if (newLength == 0){
            return null;
        }
        final Car[] newCars = new Car[newLength];
        System.arraycopy(cars, 0, newCars, 0, newLength);
        return newCars;
    }

    @Override
    public Car getById(final String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void delete(final String id) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index,
                    cars.length - (index + 1));
        }
    }

    public void updateColor(final String id, final Color color) {
        final Car car = getById(id);
        if (car != null) {
            car.setColor(color);
        }
    }

    private void increaseArray() {
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        cars = newCars;
    }

    public int foundLength() {
        int newLength = 0;
        for (Car car : cars) {
            if (car != null) {
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
    }

    @Override
    public void insert(int index, final Car car) {
        int emptyIndex = findEmptyIndex(cars);
        if (emptyIndex == -1) {
            save(car);
        } else {
            if (index >= emptyIndex) {
                save(car);
            } else {
                putCarByIndex(index, car, cars);
            }
        }
    }

    public int findEmptyIndex(Car[] cars) {
        int emptyIndex = -1;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                emptyIndex = i;
            }
        }
        return emptyIndex;
    }

    public void putCarByIndex(int index, final Car car, Car[] cars) {
        System.arraycopy(cars, index, cars, index + 1,
                cars.length - (index + 1));
        cars[index] = car;
    }
}