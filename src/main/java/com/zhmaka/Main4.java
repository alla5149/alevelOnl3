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
// OR the second method
        String Java = "Java Exercises"; // false in the requirements
        String Java1 = "Java Exercise"; // true in the requirements
        int JavaLength = Java.length();
        int Java1Length = Java1.length();
        boolean foundIt = false;
        for (int i = 0;
             i <= (JavaLength - Java1Length);
             i++) {
            if (Java.regionMatches(i, Java1, 0, Java1Length)) {
                foundIt = true;
                System.out.println(Java.substring(i, i + Java1Length));
                break;
            }
        }
        if (!foundIt)
            System.out.println("Strings aren't compared");
        // Task 3
    }
}
