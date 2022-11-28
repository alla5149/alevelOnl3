package com.zhmaka.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomGeneratorTest {
    private RandomGenerator randomGenerator;
    private RandomGenerator target;


    @Test
   void createRandomGenerator_Test() {
        Mockito.when(randomGenerator.genRandom()).thenReturn(10);
        final int min = 0;
        final int max = target.max;
        Assertions.assertNotEquals(0, 10);
    }
}
