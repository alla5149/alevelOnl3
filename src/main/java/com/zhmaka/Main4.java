package com.zhmaka;


public class Main4 {
    public static void main(String[] args) {
        // 1 Task
        String word = "Hello World";
        char a = word.charAt(0);
        char b = word.charAt(10);
        System.out.println(a + " " + b);

     /*String word = "Hello World!";
     System.out.println("First element in the line is: " + word.substring(word.length()));
     System.out.println("The last element in the line is: " + word.substring(word.length()));
       */
        // 2 Task
        String java = "Java Exercises";
        String java1 = "Java Exercise";
        if (java.equals(java1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
