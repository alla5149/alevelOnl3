package com.zhmaka;

import java.util.Scanner;
import java.util.Random;

//Homework2 Task 1
public class Main2 {
    public static void main(String[] args) {
        {
            double a, b, c, p, S;
            Scanner in = new Scanner(System.in);
            a = in.nextDouble();
            b = in.nextDouble();
            c = in.nextDouble();
            if (a + b >= c && b + c >= a && a + c >= b) {
                p = (a + b + c) / 2;
                S = (p * (p - a) * (p - b) * (p - c));
                System.out.println(S);
            } else {
                System.out.println("Трикутник не існує");
            }
            System.out.println();

            //Task 2
            int A = (int) (Math.random() * 1000);
            int B = (int) (Math.random() * 1000);
            int C = (int) (Math.random() * 1000);

            System.out.println(Math.abs(A));
            System.out.println(Math.abs(B));
            System.out.println(Math.abs(C));
            int AB = Math.min(A,B);
            int AC = Math.min(A,C);
            int min = Math.min(AB, C);
            int minByModule =  A<B ? AC : min;
            System.out.println("Наименьшее вещественное число по модулю: " + minByModule);

        }
        System.out.println();

        //Task 3
        int a = (int) (Math.random() * 100);
        System.out.println(a);
        if (a % 2 == 0) {
            System.out.println("Число парное ");
        } else {
            System.out.println("Число непарне ");
        }

        System.out.println();

        // Task 4
        int dec_number;
        int quot;
        int s = 1;
        int j;
        int bin_number[] = new int [100];
        System.out.println("Введіть 10-не число: ");
        Scanner scn = new Scanner(System.in);
        dec_number = scn.nextInt();
        quot = dec_number;

        while (quot !=0){
            bin_number[s++] = quot%2;
            quot = quot/2;
        }
        System.out.println("Двійкове число дорівнює: ");

        for (j = s-1; j>0; j--){
            System.out.print(bin_number[j]);
        }
    }
}



