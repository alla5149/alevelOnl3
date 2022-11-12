package com.zhmaka;

import java.util.Arrays;
import java.util.Random;

public class Main5 {
    public static void main(String[] args) {
        randomArray();
        oddNumber();
        increasingSequence();
        twoArrays();

    }

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
        System.out.println("The last index of the biggest number is " + index);
        System.out.println("This is the start of task 2");
    }

    public static void oddNumber() {
        int[] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = ((int) (Math.random() * 9) + 1);
            System.out.println(Arrays.toString(array2));
        }
        System.out.println();
        for (int i = 0; i < array2.length; i++) {
            if (!(i % 2 == 0)) {
                array2[i] = 0;
            }
            System.out.println(Arrays.toString(array2));
        }
        System.out.println("This is the start of task 3");
    }

    public static void increasingSequence() {
        int[] array3 = new int[4];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = (int) (Math.random() * 90) + 10;
        }
        System.out.println(Arrays.toString(array3));
        boolean increasingSequence = true;
        for (int i = 1; i < array3.length; i++) {
            if (array3[i] <= array3[i - 1]) {
                increasingSequence = false;
                break;
            }
        }
        if (increasingSequence) {
            System.out.println("Array has an increasing sequence");
        } else {
            System.out.println("Array hasn't an increasing sequence");
        }
        System.out.println("This is the start of task 4 ");
    }

    public static void twoArrays() {

        int[] array4 = new int[5];
        double sumArray4 = 0;
        for (int i = 0; i < array4.length; i++) {
            array4[i] = (int) (Math.random() * 6);
            System.out.print(array4[i] + " ");
            sumArray4 = 0;
            sumArray4 += (double) array4[i] / array4.length;
            System.out.println(sumArray4);
        }
        System.out.println();
        int[] array5 = new int[5];
        double sumArray5 = 0;
        for (int i = 0; i < array5.length; i++) {
            array5[i] = (int) (Math.random() * 6);
            System.out.print(array5[i] + " ");
            sumArray5 = 0;
            sumArray5 += (double) array5[i] / array5.length;
            System.out.println(sumArray4);
        }
        System.out.println();
        if (sumArray4 == sumArray5) {
            System.out.println("Средние арифметические значения двух массивов равны");
        } else if (sumArray4 > sumArray5) {
            System.out.println("Среднее арифметическое значение первого массива больше и равно ");
        } else {
            System.out.println("Среднее арифметическое значение второго массива больше и равно ");

        }
    }
}






