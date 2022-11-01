package com.zhmaka;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        // 1 Task
        Scanner scn = new Scanner(System.in);
        System.out.println("Write the first name of Java program");
        String str3 = scn.nextLine();
        System.out.println("First letter of sentence: " + str3.charAt(0));
        System.out.println("Last element of sentence: " + str3.charAt(str3.length()-1));

        // or short method
        String firstProgram = "Hello world!";
        System.out.println("First element of sentence: " + firstProgram.charAt(0));
        System.out.println("Last element of sentence: " + firstProgram.charAt(firstProgram.length()-1));

        // 2 Task
        String java = "Java Exercises";
        String java1 = "Java Exercise";
        if (java.equals(java1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        // The second method
        String java2 = "Java Exercises"; // false in the requirements
        String java3 = "Java Exercise"; // true in the requirements
        int java2length = java2.length();
        int java3length = java3.length();
        boolean foundIt = false;
        for (int i = 0;
             i <= (java2length - java3length);
             i++) {
            if (java2.regionMatches(i, java3, 0, java3length)) {
                foundIt = true;
                System.out.println(java2.substring(i, i + java3length));
                break;
            }
        }
        if (!foundIt)
            System.out.println("Strings aren't compared");

        // Task 3
        String StephenKing = "Walter Winchel";
        String StephenEdwinKing = "Edwin";
        String result = String.valueOf(StephenKing.matches(StephenEdwinKing));
        System.out.println(result);

        // Task 4
        String x = "Stephen Edwin King";
        System.out.println("Walter Winchell".equals(x));
        System.out.println("stephen edwin king".equalsIgnoreCase(x));

        // Task 5
        // тут імпортувала клас і додала залежність в пум файл, бо без цього Utils не працює
        String str1 = "Rad is favorite color";
        String str2 = "Orange is also my favorite color";
        System.out.println(StringUtils.startsWithIgnoreCase(str2,"Rad"));
        
    }
}
