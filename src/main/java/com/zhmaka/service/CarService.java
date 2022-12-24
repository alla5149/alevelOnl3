package com.zhmaka.service;

import com.zhmaka.model.*;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.util.RandomGenerator;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class CarService {

    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private static CarService carService;

    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

   public static CarService getInstance(){
        if(carService == null){
            carService = new CarService(CarArrayRepository.getInstance());
        }
        return carService;
   }

    public static CarService getInstance(final CarArrayRepository repository) {
        if (carService == null) {
            carService = new CarService(repository);
        }
        return carService;
    }

    public Car create() {
        final Color color = getRandomColor();
        final Car car = new PassengerCar(color);
        carArrayRepository.save(car);
        return car;
    }

    public int create(final int count) {
        if (count <= 0) {
            return -1;
        }
        for (int i = 0; i < count; i++) {
            create();
        }
        return count;
    }

    public int create(final RandomGenerator randomGenerator) {
        if (randomGenerator == null) {
            return -1;
        }
        int count = randomGenerator.genRandom();
        if (count <= 0) {
            return -1;
        }
        create(count);
        printAll();
        return count;
    }

    public Car createCar(Type type) {
        final Color color = getRandomColor();
        final Car car;
        if (type.equals(Type.CAR)) {
            car = new PassengerCar(color);
        } else if (type.equals(Type.TRUCK)) {
            car = new Truck(color);
        } else {
            car = null;
        }
        return car;
    }

    public boolean carEquals(Car car1, Car car2) {
        if (car1 == null || car2 == null) {
            return false;
        }
        if (car1.getType() != car2.getType()) {
            return false;
        }
        if (car1.hashCode() != car2.hashCode()) {
            return false;
        }
        return car1.equals(car2);
    }

    //метод printManufacturerAndCount - якщо значення присутнє, то на консоль виводиться
    //повідомлення про виробника і кількість (ifPresent & isPresent)
    public void printManufacturerAndCount(final Car car) {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        optionalCar.ifPresent(val -> System.out.println(val.getCount() + " " + val.getManufacturer()));
    }

//метод printColor - якщо значення немає - створюється нова машина випадкового типу.
//Виводиться на консоль колір машини (orElse)
    public void printColor(final Car car) {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        System.out.println(optionalCar.orElse(new PassengerCar(getRandomColor())).getColor().toString());
    }
//метод checkCount - фільтрується значення за кількістю, воно повинно бути більше 10,
//якщо значення немає - викидається виняток. Створити своє неперевірюване виключення
//UserInputException. На консоль виводиться повідомлення про виробника та кількість.
//(filter & orElseThrow)
    public void checkCount(final Car car) throws UserInputException {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        Car car1 = optionalCar.filter(val -> val.getCount() > 10).orElseThrow(() -> new UserInputException("Number of cars equals 10 or less"));
        System.out.println(car1.getCount() + " " + car1.getType());
    }
//метод printEngineInfo - якщо значення немає - створюється нова машини випадкового
//типу і повідомляється про це в консоль. З машини дістається інформація про двигун. На
//консоль виводиться потужність двигуна. (orElseGet & map)
public void printEngineInfo(Car car) {
    car = Optional.ofNullable(car)
            .orElseGet(this::createAndGetCar);
    Optional.ofNullable(car)
            .map(Car::getEngine)
            .ifPresent(System.out::println);
}

public Car createAndGetCar(){
        Car car = createCar(Type.CAR);
    System.out.println("New car will be create");
    return car;

}

//public void printEngineInfo (Car car) {
//    Optional<Car> optionalCar = Optional.ofNullable(car);
//    optionalCar.or(() -> {
//                System.out.println("Car isn't exist. New car will be created");
//                return Optional.ofNullable(createCar(Type.CAR));
//            }).map(car1 -> car1.getEngine().
//                    getPower()).
//            ifPresent(power -> System.out.println("Engine power of car is = " + power));
//}

//метод printInfo - якщо значення є - виводиться на консоль повна інформація про машину
//через метод print, якщо значення немає - створюється випадкова машина після чого
//виводитися інформація методом print (ifPresentOrElse)

    public void  printInfo(final Car car){
        Optional<Car> optionalCar = Optional.ofNullable(car);
        optionalCar.ifPresentOrElse(car1 ->{
            print(car1);
        }, () -> {
            final Car newCar = createCar(Type.CAR);
            printInfo(newCar);
        });
    }

       /* public int createPassengerCar (RandomGenerator randomGenerator){
            int count = randomGenerator.genRandom();
            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    PassengerCar passengerCar = createPassengerCar();
                    print(passengerCar);
                }
                return count;
            }
            return -1;
        }

        public int createTruck (RandomGenerator randomGenerator){
            int count = randomGenerator.genRandom();
            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    Truck truck = createTruck();
                    print(truck);
                }
                return count;
            }
            return -1;
        }
*/

    public void insert(int index, final Car car) {
        if (index < 0 || car == null) {
            return;
        }
        carArrayRepository.insert(index, car);
    }

    public void check (final Car car){
        if(car == null){
            return;
        }
        if (car.getEngine() == null){
            System.out.println("Engine is null");
            return;
        }
        if (car.getCount() > 0 && car.getEngine().getPower() > 200){
            System.out.println("Car is already prepared to sell");
        } else if (car.getCount() < 1 && (car.getEngine().getPower() > 200)) {
            System.out.println("The needed type of car isn't exist");
        } else if (car.getCount() >= 1 && (car.getEngine().getPower() <= 200)) {
            System.out.println("Мощность двигателя меньше или равно 200");
        } else {
            System.out.println("Нет нужного количества автомобилей с нужным объемом двигателя");
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
        System.out.println();
    }

    public Car[] getAll() {
        if(carArrayRepository.getAll() == null){
            return new Car[0];
        }
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
        findChangeRandomColor(car);
    }

    private void findChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public void print(Car car) {
        System.out.println("id: " + car.getId() +
                "; Type car: " + car.getType() +
                "; Manufacturer: " + car.getManufacturer() +
                "; Engine: " + car.getEngine() +
                "; Color: " + car.getColor() +
                "; Count: " + car.getCount() +
                "; Price: " + car.getPrice());
    }

    public String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = random.nextInt(10);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public int compareCar(final Car first, final Car second) {
        return first.getId().compareTo(second.getId());
    }

}