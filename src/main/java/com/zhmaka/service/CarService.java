package com.zhmaka.service;

import com.zhmaka.model.*;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.util.RandomGenerator;

import java.io.ObjectInputFilter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarService {

    private final CarArrayRepository carArrayRepository;
    private final Random random = new Random();
    private static CarService carService;

    static List<Car> cars;


    public CarService(final CarArrayRepository carArrayRepository, List<Car> cars) {
        this.carArrayRepository = carArrayRepository;
        this.cars = cars;
    }

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService(CarArrayRepository.getInstance(), cars);
        }
        return carService;
    }

    public static CarService getInstance(final CarArrayRepository repository) {
        if (carService == null) {
            carService = new CarService(repository, cars);
        }
        return carService;
    }

    public Car create() {
        final Color color = getRandomColor();
        final Car car = new PassengerCar(color);
        carArrayRepository.save(car);
        return car;
    }

//    public Car[] create(final int count) {
//        if (count <= 0) {
//            return -1;
//        }
//        for (int i = 0; i < count; i++) {
//            create();
//        }
//        return count;
//    }

    public int create(final RandomGenerator randomGenerator) {
        if (randomGenerator == null) {
            return -1;
        }
        int count = randomGenerator.genRandom();
        if (count <= 0) {
            return -1;
        }
        create();
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

    public Car [] getAll() {
        if (carArrayRepository.getAll() == null) {
            return new Car[0];
        }
        return carArrayRepository.getAll();
    }

    public Optional<Car> findByID(final String id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findAny();
    }

    public List<Car> findByManufacturer(final Manufacturer manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer)).collect(Collectors.toList());
    }


    public void delete(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carArrayRepository.delete(id);
    }

    public void insert(int index, final Car car) {
        if (index < 0 || car == null) {
            return;
        }
        carArrayRepository.insert(index, car);
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

    public void printManufacturerAndCount(final Car car) {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        optionalCar.ifPresent(val -> System.out.println(val.getCount() + " " + val.getManufacturer()));
    }

    public void printColor(final Car car) {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        System.out.println(optionalCar.orElse(new PassengerCar(getRandomColor())).getColor().toString());
    }

    public void checkCount(final Car car) throws UserInputException {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        Car car1 = optionalCar.filter(val -> val.getCount() > 10)
                .orElseThrow(() -> new UserInputException("Number of cars equals 10 or less"));
        System.out.println(car1.getCount() + " " + car1.getType());
    }

    public void printEngineInfo(Car car) {
        car = Optional.ofNullable(car).orElseGet(this::createAndGetCar);
        Optional.ofNullable(car).map(Car::getEngine).ifPresent(System.out::println);
    }

    public Car createAndGetCar(){
        Car car = createCar(Type.CAR);
        System.out.println("New car will be create");
        return car;
    }

    public void printInfo(final Car car) {
        Optional<Car> optionalCar = Optional.ofNullable(car);
        optionalCar.ifPresentOrElse(car1 -> {
            print(car1);
        }, () -> {
            final Car newCar = createCar(Type.CAR);
            printInfo(newCar);
        });
    }

    public Map<Manufacturer, Integer> mapManufacturerAndCount(final List<? extends Car> cars) {
        final Map<Manufacturer, Integer> map = cars.stream()
                .collect(Collectors.toMap(Car::getManufacturer, Car::getCount, (x, getElement) -> x));
        return map;

    }

//    public Map<Engine, List<Car>> mapEngineInCarList(final List<? extends Car> cars){
//        final List<Engine> list = cars.stream().map(Car::getEngine).collect(Collectors.toList());
//        Map<Integer, List<Car>> map = new HashMap<>();
//        for (Engine engine : list) {
//            List<Car> carWithSameEngine = Arrays.stream(getAll())
//                    .filter(x -> x.getEngine().equals(engine)).collect(Collectors.toList());
//            map.put(engine.getPower(), carWithSameEngine);
//        }
//        return map;
//    }


//    17 HOMEWORK
//    findManafacturerByPrice Знайти машини дорожчі за ціну Х і показати їхнього виробника

    public void findManafacturerByPrice(final List<? extends Car> cars, int price) {
        List<Manufacturer> manufacturers = cars.stream().filter(x -> x.getPrice() > price).map(Car::getManufacturer)
                .collect(Collectors.toList());
    }

    // countSum Порахувати суму машин через reduce

    public int countSum(final List<? extends Car> cars) {
        int sum = cars.stream().map(Car::getPrice).reduce(0, Integer::sum);
        return sum;
    }

//    mapToMap Відсортувати машини за виробником, прибрати дублікати, перетворити на
//    Map, де ключ - це id машини, а значення - це її тип (зберігаючи порядок)


    public Map<String, Type> mapToMap(final List<? extends Car> cars) {
        HashMap<String, Type> map = cars.stream().sorted(Comparator.comparing(Car::getManufacturer)).distinct().
                collect(Collectors.toMap(Car::getId, Car::getType, (x, y) -> y, HashMap::new));
        System.out.println("Sorted steam " + map);
        return map;
    }

    //    statistic Отримати статистику за ціною всіх машин
    public DoubleSummaryStatistics stats(final List<? extends Car> cars) {
        DoubleSummaryStatistics stats = cars.stream().collect(Collectors.summarizingDouble(Car::getPrice));
        return stats;
    }

    //    priceCheck Написати реалізацію предиката, який перевіряє, що в переданій колекції в усіх
//    машин є ціна, вища за число Х.
    public boolean priceCheck(final List<? extends Car> cars, int price) {
        boolean match = cars.stream().allMatch(car -> car.getPrice() > price);
        return match;
    }


//    mapToObject Написати реалізацію Function, яка приймає Map<String, Object> і створює
//    конкретну машину на підставі полів Map

    // Це не мій метод. Я його не писала. Я перевірила як він працює. Але код закоментований. Його не оцінюйте будь ласка

//    public Function<Map<String, Object>, Car> mapToObject = map -> {
//        Type type = (Type) map.getOrDefault("type", Type.CAR);
//        if (type == Type.CAR) {
//            return createPassengerCar(map);
//        } else {
//            return createTruck(map);
//        }
//    };
//
//    private PassengerCar createPassengerCar(final Map<String, Object> map) {
//        final PassengerCar passengerCar = (PassengerCar) createAbstractCar(Type.CAR, map);
//        final int passengerCount = (int) map.getOrDefault("passengerCount", 1);
//        passengerCar.setPassengerCaunt(passengerCount);
//    }
//
//    private Truck createTruck(final Map<String, Object> map) {
//        final Truck truck = (Truck) createAbstractCar(Type.TRUCK, map);
//        final int loadCapacity = (int) map.getOrDefault("loadCapacity", 10);
//        truck.setLoadCapacity(loadCapacity);
//        return truck;
//    }
//
//    private Car createAbstractCar(final Type type, final Map<String, Object> map) {
//        final Car car;
//        if (type == Type.CAR) {
//            car = new PassengerCar();
//
//        } else {
//            car = new Truck();
//        }
//        final int count = (int) map.getOrDefault("count", 10);
//        car.setCount(count);
//        final Color color = (Color) map.getOrDefault("color", Color.GOLD);
//        car.setColor(color);
//        return car;
//    }


//    innerList метод приймає колекцію List<List<Car>>, дістає машини, сортує за кольорами,
//    виводить інформацію на консоль, фільтрує за ціною, збирає в Map, де ключ - це колір, а
//    значення - к-ть машин

    public Map <Color, Integer> innerList(final List<List<Car>> cars) {
        Map<Color, Integer> map = cars.stream().flatMap(List::stream)
                .sorted(Comparator.comparing(Car::getColor))
                .peek(System.out::println)
                .filter(x -> x.getPrice() > 1000)
                .collect(Collectors.toMap(Car::getColor, Car::getCount));
        return map;
    }



    public static void check(final Car car) {
        if (car == null) {
            return;
        }
        if (car.getEngine() == null) {
            System.out.println("Engine is null");
            return;
        }
        if (car.getCount() > 0 && car.getEngine().getPower() > 200) {
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


//    public void changeRandomColor(final String id) {
//        if (id == null || id.isEmpty()) {
//            return;
//        }
//        final Car car = findByID(id);
//        if (car == null) {
//            return;
//        }
//        findChangeRandomColor(car);
//    }

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

    public int compareCar(Car currentCar, Car nextCar) {
        return currentCar.getId().compareTo(nextCar.getId());
    }


}



