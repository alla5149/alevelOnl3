package com.zhmaka.action;

import com.zhmaka.util.UserInput;
import lombok.SneakyThrows;

import java.util.Optional;

public class CreateAction implements Action{
    private static final int DEFAULT_CARS = 10;

    @SneakyThrows
    @Override
    public void execute() {
        String[] strings = {"Input your number of cars", "Default number"};
        final int userChoice = UserInput.menu(strings);

        int countOfCars;
        if (userChoice == 0) {
            countOfCars = Optional.of(UserInput.getInt("How many cars do you want to create?"))
                    .filter(c -> c >= 1)
                    .orElse(DEFAULT_CARS);
        } else {
            countOfCars = DEFAULT_CARS;
        }

        CAR_SERVICE.create(countOfCars);
        System.out.printf("Created %d cars%n", countOfCars);
    }
}
