package dev.yojanpardo;

public class Palindromos {
    public static void main(String[] args) {
        final String word = "ana";
        System.out.printf("word [%s] is palindrome: %b%n", word, isPalindrome(word));
    }

    private static boolean isPalindrome(final String word) {
        final String wordWithoutSpaces = word.replace(" ", "");
        int left = 0;
        int right = wordWithoutSpaces.length() - 1;
        while(left < right){
            if(wordWithoutSpaces.charAt(left) != wordWithoutSpaces.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
