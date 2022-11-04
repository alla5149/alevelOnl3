package com.zhmaka;

import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {
        randomArray();

    }
// Task 1
    public static void randomArray() {
        int[] array1 = new int[12];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = ((int) (Math.random() * 31) - 15);
            System.out.println(Arrays.toString(array1));
        }
        System.out.println();
        int maxNumber = -16;
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            if (maxNumber <= array1[i]) {
                maxNumber = array1[i];
                index = i;
            }
        }
        System.out.println(index);
    }
    //Task 2


    


}