package com.zhmaka.service;

import com.zhmaka.model.*;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

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
        final Car car = target.create();
        Assertions.assertNotNull(car);
        Assertions.assertNotEquals(0, car.getPrice());
    }


    @Test
    void create_createTruck() {
        final Car car = target.create();
        Assertions.assertNotNull(car);
        Assertions.assertNotEquals(0, car.getPrice());
    }


//    @Test
//    void createCarRandom(){
//        randomGenerator = Mockito.mock(RandomGenerator.class);
//        Mockito.when(randomGenerator.genRandom()).thenReturn(2);
//        final int actual = target.create();
//        final int expected = 2;
//        Assertions.assertEquals(expected, actual);
//    }

//    @Test
//    void createTruckRandom(){
//        randomGenerator = Mockito.mock(RandomGenerator.class);
//        Mockito.when(randomGenerator.genRandom()).thenReturn(1);
//        final int expected = 1;
//        final int actual = target.create();
//        Assertions.assertEquals(expected, actual);
//    }

    /*@Test
    void createNegativeNumCars(){
        randomGenerator = Mockito.mock(RandomGenerator.class);
        Mockito.when(randomGenerator.genRandom()).thenReturn(-5);
        final int expected = -1;
        final int actual = target.createCar(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }
     */
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

    @Test
    void printManufacturerAndCount_notNull(){
        Assertions.assertDoesNotThrow(()-> target.printManufacturerAndCount(car));
    }
    @Test
    void printManufacturerAndCount_Null() {
        Optional<Car> opt = Optional.ofNullable(null);
        Assertions.assertDoesNotThrow(() -> target.printManufacturerAndCount(null));
    }
@Test
boolean printEngineInfo(Car car) {
       boolean typeCar = true;
    if (car != null && car.getEngine() != null
            && car.getType() == Type.CAR
            && car.getType() == Type.TRUCK) {

        typeCar = true;
    }
    return true;
}

    @Test
    void printColor_exist() {
        Assertions.assertDoesNotThrow(() -> target.printColor(car));
    }

    @Test
    void checkCount_not_Empty() {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        car.setCount(2);
        if(car != null) {
            Assertions.assertDoesNotThrow(() -> target.checkCount(car));
        }
    }

    @Test
    void checkCount_Null() {
//        Assertions.assertNull(null, "UserInputException");
//        Assertions.assertThrows(UserInputException.class, ()-> target.checkCount(car));
        try {
            Optional.of(null);
        } catch (Exception e) {
            assert e instanceof NullPointerException;
        }
    }


    @Test
    void printEngineInfo_empty() {
        Assertions.assertDoesNotThrow(() -> target.printEngineInfo(null));
    }

    @Test
    void printEngineInfo() {
        Assertions.assertDoesNotThrow(() -> target.printEngineInfo(car));
    }

    @Test
    void printInfo_aboutCar() {
        Assertions.assertDoesNotThrow(() -> target.printInfo(car));
    }

    @Test
    void printInfo_Is_null() {
        Assertions.assertDoesNotThrow(() -> target.printInfo(null));
    }

}
