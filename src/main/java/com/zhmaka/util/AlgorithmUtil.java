package com.zhmaka.util;

import com.zhmaka.model.Car;
import com.zhmaka.repository.CarArrayRepository;
import com.zhmaka.service.CarService;

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


// Це не мій метод. Але я не можу зробити "свій".
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





    
}










