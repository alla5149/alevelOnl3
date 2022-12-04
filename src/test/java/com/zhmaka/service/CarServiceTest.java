package com.zhmaka.service;

import com.zhmaka.model.Car;
import com.zhmaka.model.Engine;
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
    }

    @Test
    void create_NewCar() {
        final Car car = target.create();
        Assertions.assertNotNull(car);
        Assertions.assertNotEquals(0, car.getPrice());
    }

    @Test
    void createFewCar() {
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(2);
        final int expected = 2;
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    final int createNotZero() {
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(-1);
        final int expected = -1;
        final int actual = target.create(randomGenerator);
        if (actual > 0) {
            System.out.println("Количество машин не может быть отрицательным");
        }
        return expected;
    }

    @Test
    void checkCountAndEngine() {
        final Car car = Mockito.mock(Car.class);
        Mockito.when(car.getEngine()).thenReturn(new Engine());
        Mockito.when(car.getCount()).thenReturn(1);
        Assertions.assertDoesNotThrow(() -> target.check(car));
    }


    @Test
    void insertZero() {
        final Car car = new Car();
        target.insert(0, car);
        Mockito.verify(repository).insert(0, car);
    }

    @Test
    void print() {
        final Car car = new Car();
        Assertions.assertDoesNotThrow(() -> target.print(car));
    }

    @Test
    void printAll() {
        final Car[] cars = new Car[0];
        Mockito.when(repository.getAll()).thenReturn(cars);
        Assertions.assertDoesNotThrow(() -> target.printAll(cars));
    }

    @Test
    void getAllIsNull() {
        final Car[] car = target.getAll();
        Assertions.assertNull(car);
    }

    @Test
    void find() {
        final Car newCar = new Car();
        String id = "5149";
        Mockito.when(repository.getById("5149")).thenReturn(newCar);
        final Car actualCar = target.find(id);
        Assertions.assertEquals(newCar, actualCar);
    }

    @Test
    void delete() {
        final String id = "5149";
        target.delete(id);
        Mockito.verify(repository).delete(id);
    }
}