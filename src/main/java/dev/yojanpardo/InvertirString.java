package dev.yojanpardo;

public class InvertirString {

    public static void main(String[] args) {
        char[] testArray = {'h','o','l','a',' ','m','u','n','d','o'};
        invertirString(testArray);
        for (char j : testArray) {
            System.out.print(j);
        }
    }

    private static void invertirString(char[] testArray) {
        int start = 0;
        int end = testArray.length - 1;
        while(start < end) {
            char temp = testArray[start];
            testArray[start] = testArray[end];
            testArray[end] = temp;
            start++;
            end--;
        }
    }
}
