package com.zhmaka.util;

import com.zhmaka.model.Car;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.service.CarService;

import java.util.Arrays;

public class AlgorithmUtil {
    private static final CarService CAR_SERVICE = CarService.getInstance();
    private static final CarArrayRepository CAR_ARRAY_REPOSITORY = CarArrayRepository.getInstance();


    public static int compare(Car car1, Car car2) {
        return car1.getId().compareTo(car2.getId());
    }

    public static int binarySearch(Car cars[], Car carSearch) {
        int firstIndex = 0;
        int lastIndex = cars.length - 1;
        while (firstIndex <= lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            if (compare(cars[mid], carSearch) == 0) {
                return mid;
            } else if (compare(cars[mid], carSearch) < 0) {
                firstIndex = mid + 1;
            } else if (compare(cars[mid], carSearch) > 0) {
                lastIndex = mid - 1;
            }
        }
        return -1;
    }


    public static boolean bubbleSort(Car[] cars) {
        for (Car car : cars) {
            CAR_ARRAY_REPOSITORY.save(car);
        }
        Car temp;
        for (int i = 0; i < cars.length - 1; i++) {
            boolean checkPos = true;
            for (int j = 0; j < cars.length - i; j++) {
                if (compare(cars[i], cars[j]) > 0) {
                    temp = cars[j];
                    cars[j] = cars[i + 1];
                    cars[i + 1] = temp;
                    if (!checkPos) {
                        checkPos = true;
                    }
                }
            }
            if (!checkPos) {
                break;
            }
        }
        System.out.println(Arrays.toString(cars));
        return false;
    }
}


// Це не мій метод.
// В мене не настільки досвіду. Але я можу скористатися з рекомендованих в мережі
//stackoverflow.com/questions/40196002/implement-binary-search-using-the-collections-binarysearch-signature
//    public class BinarySearch {
//        public static <Q extends Comparable<? super T>, T>
//        int search(List<Q> xs, T x) {
//            return search(xs, x, Q::compareTo);
//        }
//
////        public static <T>
//        int search(List<? extends T> xs, T x, Comparator<? super T> cmp) {
//            int l = 0,
//            r = xs.size() - 1;
//
//            while (l <= r) {
//                int mid = l + (r - l) / 2;
//
//                if (cmp.compare(xs.get(mid), x) == 0)
//                    return mid;
//
//                if (cmp.compare(xs.get(mid), x) < 0)
//                    r = mid - 1;
//                else
//                    l = mid + 1;
//            }
//
//            return xs.size();
//        }

// https://stackoverflow.com/questions/31397823/java-array-bubble-sorting
//   int[] numbers = { 5, 8, 14, 1, 5678 };
//2  |  int tempVar;
//3  |  for (int i = 0; i < numbers.length; i++)
//            4  |   {
//        5  |       for(int j = 0; j < numbers.length; j++)
//            6  |       {
//                    7  |                if(numbers[i] > numbers[j + 1])
//            8  |                {
//                    9  |                        tempVar = numbers [j + 1];
//        10 |                        numbers [j + 1]= numbers [i];
//        11 |                        numbers [i] = tempVar;
//        12 |                 }
//        13 |        }
//        14 |  }
//15 |  for (int i = 0; i < numbers.length; i++)
//            16 |  {
//        17 |           System.out.println(numbers[i].toString());
//        18 |  }














