package dev.yojanpardo.colasypilas;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * este es un ejecicio de colas de prioridad.
 * dada una condicion vamos a tener una cola organizqda con una prioridad que
 * definimos bajo una condicion dada.
 */
public class KClosesPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{2, 3}, {3, 3}, {1, 2}, {4, 5}};
        int k = 2;
        int[][] closestPoints = findClosestPoints(points, k);

        for(int[] point : closestPoints){
            System.out.printf("[%d, %d] ", point[0], point[1]);
        }
    }

    private static int[][] findClosestPoints(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        Collections.addAll(queue, points);
        int[][] result = new int[k][];
        for(int i = 0; i<k; i++){
            result[i] = queue.poll();
        }

        return result;
    }
}
