package dev.yojanpardo;

public class Fibonacci {
    public static void main(String[] args) {
        long anterior = 0;
        System.out.println(anterior);
        long actual = 1;
        System.out.println(actual);
        long siguiente = anterior + actual;
        final int limite = 10;
        for(int i = 0; i < limite; i++) {
            System.out.println(siguiente);
            anterior = actual;
            actual = siguiente;
            siguiente = anterior + actual;
        }
    }
}
