package com.zhmaka.service;

import com.zhmaka.model.*;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.util.RandomGenerator;

import java.util.Arrays;
import java.util.Random;

public class CarService {

        private final CarArrayRepository carArrayRepository;
        private final Random random = new Random();

        public CarService(final CarArrayRepository carArrayRepository) {
            this.carArrayRepository = carArrayRepository;
        }

   /* public PassengerCar createPassengerCar() {
        final PassengerCar passengerCar = new PassengerCar(manufacturer, color, engine);
        Engine engine = new Engine();
        passengerCar.setManufacturer(getRandomString());
        passengerCar.setEngine(engine);
        passengerCar.setColor(getRandomColor());
        passengerCar.setPrice(random.nextInt(1000));
        passengerCar.setPassengerCaunt(random.nextInt(5));
        passengerCar.setCount(1);
        passengerCar.setType(Type.CAR);
        passengerCar.restore();
        carArrayRepository.save(passengerCar);
        return passengerCar;
    }

    public Truck createTruck() {
        final Truck truck = new Truck(manufacturer, color, engine);
        Engine engine = new Engine();
        truck.setManufacturer(getRandomString());
        truck.setEngine(engine);
        truck.setColor(getRandomColor());
        truck.setPrice(random.nextInt(1000));
        truck.setLoadCapacity(random.nextInt(1000));
        truck.setCount(1);
        truck.setType(Type.TRUCK);
        truck.restore();
        carArrayRepository.save(truck);
        return truck;
    }

    */

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

        public Car create(Type type) {
            final Color color = getRandomColor();
            final Car car = new PassengerCar(getRandomString(), getRandomColor(), new Engine(getRandomString()));
            carArrayRepository.save(car);
            return car;
        }

        public int create(final int count) {
            if (count <= 0) {
                return -1;
            }
            for (int i = 0; i < count; i++) {
                create(Type.CAR);
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

        public void check(Car car) {
            if (car.getCount() > 1 && (car.getEngine().getPower() > 200)) {
                System.out.println("Авто готове до продажу");
            } else if (car.getCount() < 1 && (car.getEngine().getPower() > 200)) {
                System.out.println("Нет нужного количества автомобилей");
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

    }