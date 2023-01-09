package com.zhmaka.action;

import com.zhmaka.model.Car;

public class CompareAction implements Action{
    @Override
    public void execute() {
        CAR_SERVICE.create(5);
        final Car[] all = CAR_SERVICE.getAll().toArray(new Car[0]);
        for (int i = 0; i < all.length - 1; i++) {
            Car currentCar = all[i];
            Car nextCar = all[i + 1];
            final int compare = CAR_SERVICE.compareCar(currentCar, nextCar);
            System.out.println("Current car: " + currentCar.getId());
            System.out.println("Next car: " + nextCar.getId());
            System.out.println("Compare: " + compare);
            System.out.println("~".repeat(5));
        }
    }
}
