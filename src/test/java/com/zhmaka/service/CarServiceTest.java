package com.zhmaka.service;

import com.zhmaka.model.*;
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
    void create_createPassCar() {
        final Car car = target.create(Type.CAR);
        Assertions.assertNotNull(car);
        Assertions.assertNotEquals(0, car.getPrice());
    }


    @Test
    void create_createTruck() {
        final Car car = target.create(Type.TRUCK);
        Assertions.assertNotNull(car);
        Assertions.assertNotEquals(0, car.getPrice());
    }


   @Test
    void createCarRandom(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(2);
        final int actual = target.create(randomGenerator);
        final int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createTruckRandom(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(1);
        final int expected = 1;
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createNegativeNumCars(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(-5);
        final int expected = -1;
        final int actual = target.createCar(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkIndexZero(){
        final Car car = new PassengerCar();
        target.insert(0, car);
        Mockito.verify(repository).insert(0, car);
    }

    @Test
    void checkIndexMoreThan0(){
        final Car car = new PassengerCar();
        target.insert(7, car);
        Mockito.verify(repository).insert(0, car);
        }

    @Test
    void print() {
        final Car car = new PassengerCar();
        Assertions.assertDoesNotThrow(() -> target.print(car));
    }

    @Test
    void printAll() {
        Assertions.assertDoesNotThrow(() -> target.printAll());
    }

    @Test
    void find() {
        final Car car  = target.find("5149");
        Mockito.when(repository.getById("5149")).thenReturn(car);
        Assertions.assertNotNull(car);
        Mockito.verify(repository).getById(Mockito.anyString());
    }

    @Test
    void deleteEmptyID() {
        final String id = " ";
        Assertions.assertDoesNotThrow(() -> target.delete(id));
        Mockito.verify(repository, Mockito.never()).delete(id);
    }

    @Test
    void carEqualsCar(){
        final boolean expected = true;
        boolean actual = target.carEquals(car, car);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void twoSameColorCar(){
        final boolean expected = false;
        Car car1 = new PassengerCar(Color.GOLD);
        Car car2 = new PassengerCar(Color.GOLD);
        boolean actualValue = target.carEquals(car1, car2);
        Assertions.assertEquals(actualValue, expected);
    }

}