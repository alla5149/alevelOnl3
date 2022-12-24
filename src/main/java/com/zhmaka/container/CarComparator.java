package com.zhmaka.container;

import com.zhmaka.model.Car;

import java.util.Comparator;

public class CarComparator<T extends Car> implements Comparator {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getCount(), o2.getCount());;
    }
}
