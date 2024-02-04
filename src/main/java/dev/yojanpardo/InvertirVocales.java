package dev.yojanpardo;

public class InvertirVocales {
    public static void main(String[] args) {
        String testString = "Hola Mundo";
        System.out.println(invertirVocales(testString));
    }

    private static String invertirVocales(final String testString) {
        final char[] testStringArray = testString.toCharArray();
        int start = 0;
        int end = testStringArray.length - 1;

        while(start<end){
            char leftLetter = testStringArray[start];
            char rightLetter = testStringArray[end];

            if(!isVowel(leftLetter)) {
                start++;
            }

            if(!isVowel(rightLetter)) {
                end--;
            }

            if(isVowel(leftLetter) && isVowel(rightLetter)){
                testStringArray[start] = rightLetter;
                testStringArray[end] = leftLetter;
                start++;
                end--;
            }
        }
        return new String(testStringArray);
    }

    private static boolean isVowel(char letter) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(String.valueOf(letter));
    }
}
