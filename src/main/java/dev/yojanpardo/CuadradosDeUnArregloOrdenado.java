package dev.yojanpardo;

public class CuadradosDeUnArregloOrdenado {
    public static void main(String[] args) {
        int[] testArray = {-4,-1,0,3,10};
        int[] result = sortedSquares(testArray);
        for (int j : result) {
            System.out.println(j);
        }
    }

    private static int[] sortedSquares(int[] testArray) {
        int[] result = new int[testArray.length];
        int left = 0;
        int right = testArray.length - 1;
        int index = testArray.length - 1;
        while(left <= right) {
            int leftSquare = testArray[left] * testArray[left];
            int rightSquare = testArray[right] * testArray[right];
            if(leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }
}
