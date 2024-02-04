package dev.yojanpardo.grafosarboles.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

    static Map<Integer, Long> cache = new HashMap<>();

    static {
        cache.put(0, 0L);
        cache.put(1, 1L);

    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("ingrese el valor a calcular");

        final int fibonacciSeries = sc.nextInt();

        System.out.println("resultado final: " + calcularFibonacci(fibonacciSeries));
    }

    private static long calcularFibonacci(int n) {
        System.out.println(n);

        if(cache.get(n) != null){
            System.out.println("valor en cache: [" + n + "] : [" + cache.get(n) + "]");
            return cache.get(n);
        }

        long result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
        System.out.println("añadiendo valor: [" + result + "] a la cache en la posicion: [" + n + "]");
        cache.put(n, result);
        return result;
    }
}
