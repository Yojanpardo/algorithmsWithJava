package dev.yojanpardo.grafosarboles.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DFS {

    public static void main(String[] args) {
        System.out.println("********** DFS ***********");

        Nodo<Integer> head = prepareHead();

        System.out.println("ingrese el valor del nodo a buscar");

        Scanner sc = new Scanner(System.in);

        int valorABuscar = sc.nextInt();

        System.out.printf("valor [%s] encontrado: %b\n", valorABuscar, buscarNodo(head, valorABuscar) != null);
    }

    private static Nodo<Integer> buscarNodo(Nodo<Integer> head, int valorABuscar) {

        System.out.printf("buscando valor [%d] en nodo con valor [%d]\n", valorABuscar, head.valor);

        if(head.valor == valorABuscar){
            return head;
        }

        if(head.hijos != null) {
            for (Nodo<Integer> hijo : head.hijos) {
                Nodo<Integer> resultado = buscarNodo(hijo, valorABuscar);
                if (resultado != null && resultado.valor.equals(valorABuscar)) {
                    return resultado;
                }
            }
        }
        return null;
    }

    private static Nodo<Integer> prepareHead() {
        Nodo<Integer> cabeza = new Nodo<>(1);

        Nodo<Integer> hijo1 = new Nodo<>(2, cabeza);
        Nodo<Integer> hijo2 = new Nodo<>(3, cabeza);
        Nodo<Integer> hijo3 = new Nodo<>(4, cabeza);

        cabeza.hijos = (Arrays.asList(hijo1, hijo2, hijo3));

        Nodo<Integer> nieto1 = new Nodo<>(5, hijo1);
        Nodo<Integer> nieto2 = new Nodo<>(6, hijo1);
        Nodo<Integer> nieto3 = new Nodo<>(7, hijo1);

        hijo1.hijos = (Arrays.asList(nieto1, nieto2, nieto3));

        Nodo<Integer> nieto4 = new Nodo<>(8, hijo2);
        Nodo<Integer> nieto5 = new Nodo<>(9, hijo2);
        Nodo<Integer> nieto6 = new Nodo<>(10, hijo2);

        hijo2.hijos = (Arrays.asList(nieto4, nieto5, nieto6));

        Nodo<Integer> nieto7 = new Nodo<>(11, hijo3);
        Nodo<Integer> nieto8 = new Nodo<>(12, hijo3);
        Nodo<Integer> nieto9 = new Nodo<>(13, hijo3);

        hijo3.hijos = (Arrays.asList(nieto7, nieto8, nieto9));

        return cabeza;
    }

    static class Nodo<T> {
        T valor;
        Nodo<T> padre;
        List<Nodo<T>> hijos;

        public Nodo(T valor) {
            this.valor = valor;
        }

        public Nodo(T valor, Nodo<T> padre) {
            this.valor = valor;
            this.padre = padre;
        }
    }
}
