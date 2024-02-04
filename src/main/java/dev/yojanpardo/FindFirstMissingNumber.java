package dev.yojanpardo;

import java.util.HashSet;
import java.util.Set;

public class FindFirstMissingNumber {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println("The smallest positive integer missing is: " + findSmallestPositiveInteger(A));
    }

    private static int findSmallestPositiveInteger(int[] a) {
        final Set<Integer> numbers = new HashSet<>();
        for (int i : a) {
            numbers.add(i);
        }

        for (int i = 1; i <= a.length; i++) {
            if(!numbers.contains(i)) {
                return i;
            }
        }

        return a.length + 1;
    }

}
