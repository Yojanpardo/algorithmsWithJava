package dev.yojanpardo;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] testArray = {1,0,2,0,3,0,4,0,5,0,6,0,7,9,0,8,0};
        moveZerosToEnd(testArray);
        for (int j : testArray) {
            System.out.println(j);
        }
    }

    private static void moveZerosToEnd(int[] testArray) {
        int posicionNoCero = 0;
        for(int i = 0; i < testArray.length; i++) {
            if(testArray[i] != 0) {
                int temp = testArray[i];
                testArray[i] = testArray[posicionNoCero];
                testArray[posicionNoCero] = temp;
                posicionNoCero++;
            }
        }
    }
}
