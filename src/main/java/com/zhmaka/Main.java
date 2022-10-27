package com.zhmaka;

public class Main {
    // Homework 1 Task 3
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            if (i == 3) {
                continue;
            }
            if (i == 6) {
                break;
            }
            System.out.println("Крок " + i);
        }
        //Task 2
        int y = 5;
        for (int i = 0; i <= 10; i++) {
            System.out.println("Крок " + i + " значення " + y);
            y = y + 2;

        }
        //Task 1 to HW1
        String onl3 = "Alla Zhmaka";
        System.out.println(onl3);
        // or simple code
        System.out.println("Alla");
    }
}
