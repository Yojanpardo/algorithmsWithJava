package dev.yojanpardo;

public class Factorial {
    public static void main(String[] args) {
        int testNumber = 5;
        int factorial = 1;
        for(int i = 1; i <= testNumber; i++) {
            factorial *= i;
            System.out.println(factorial);
        }
        System.out.println(factorial);
    }
}
