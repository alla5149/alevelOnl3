package com.zhmaka.util;

import java.util.Random;

public class RandomGenerator{
    final Random random = new Random();

    int min = 0;
    int max = 10;

    public RandomGenerator() {
    }

    public int genRandom() {
        return random.nextInt(max - min) + 1;
    }
}
