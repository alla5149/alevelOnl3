package com.zhmaka;

import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) {
        randomArray();
        oddNumber();
        increasingSequence();

    }
    //Task 1
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
    //Task
    public static void oddNumber(){
        int [] array2 = new int[8];
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
public static void increasingSequence(){
    int [] array2 = new int[8];
    for (int i = 0; i < array2.length; i++) {
        array2[i] = ((int) (Math.random() * 89) + 10);
        System.out.println(Arrays.toString(array2));
    }
    System.out.println();
    

}


}

