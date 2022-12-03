package com.zhmaka.service;

import com.zhmaka.model.Car;
import com.zhmaka.model.PassengerCar;
import com.zhmaka.model.Truck;
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
    private PassengerCar car;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        randomGenerator = Mockito.mock(RandomGenerator.class);
        target = new CarService(repository);
        car = new PassengerCar();
    }

    @Test
    int create_createPassengerCar() {
        final Car passengerCar = target.createPassengerCar();
        if (passengerCar != null) {
            Assertions.assertNotNull(passengerCar);
        }
        return create_createPassengerCar();
    }

    @Test
    void create_createTruck() {
        final Car truck = target.createTruck();
        Assertions.assertNotNull(truck);
    }

    @Test
    void createPassCarRandom(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(2);
        final int expected = 2;
        final int actual = target.createPassengerCar(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createTruckRandom(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(1);
        final int expected = 1;
        final int actual = target.createTruck(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    final int createZeroPassCars(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(0);
        final int expected = 0;
        final int actual = target.createPassengerCar(randomGenerator);
        if (actual != expected){
            return actual;
        }
        return expected;
    }

    @Test
    void checkIndexZero(){
        final Car car = new Truck();
        target.insert(0, car);
        Mockito.verify(repository).insert(0, car);
    }

    @Test
    void checkIndexMoreThan0(){
        final Car car = new Truck();
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
        final String id = "5149";
        final Car expected = new PassengerCar();
        Mockito.when(repository.getById("5149")).thenReturn(expected);
        final Car actual = target.find(id);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void delete() {
        final String id = "5149";
        target.delete(id);
        Mockito.verify(repository).delete(id);
    }
}