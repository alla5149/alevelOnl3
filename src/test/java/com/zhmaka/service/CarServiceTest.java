package com.zhmaka.service;

import com.zhmaka.model.Car;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarServiceTest {
    private CarService target;
    private CarArrayRepository repository;
    private RandomGenerator randomGenerator;
    private Car car;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        randomGenerator = Mockito.mock(RandomGenerator.class);
        target = new CarService(repository);
        car = new Car(car.getManufacturer(),
                car.getEngine(),
                car.getColor());
    }

    @Test
    void verifyGetRandomString() {
        String expected = " ";


    }

    @Test
    void create_emptyCar() {
        final Car car = target.create();
        Assertions.assertNull(car);
    }

    @Test
    void create_notEmptyCar() {
        final Car car = target.create();
        Assertions.assertNotNull(car);
    }

    @Test
    void insert() {
        final int insert = 0;
        int index = 1;
        Assertions.assertDoesNotThrow(() -> target.insert(index, car));

    }

    @Test
    void print() {
        Assertions.assertDoesNotThrow(() -> target.print(car));
    }

    @Test
    void printAll() {
        final Car[] cars = new Car[0];
        Mockito.when(repository.getAll()).thenReturn(cars);
        Assertions.assertDoesNotThrow(() -> target.printAll(cars));
    }

    @Test
    void getAll() {
        final Car[] car = target.getAll();
        Assertions.assertNotNull(car);
    }

    @Test
    void find() {
        String id = "5149";
        Mockito.when(repository.getById("5149")).thenReturn(null);
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }

    @Test
    void deleteNull() {
        Assertions.assertDoesNotThrow(() -> target.delete(null));
    }
}