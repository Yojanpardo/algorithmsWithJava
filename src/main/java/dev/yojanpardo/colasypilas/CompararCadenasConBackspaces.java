package dev.yojanpardo.colasypilas;

import java.util.Stack;

/**
 * Dadas dos cadenas s y t, devuelve true si son iguales cuando ambas se escriben en editores de texto vacíos. ‘#’
 * significa un carácter de backspace (tecla de restroceso). En el caso de retroceder en una cadena vacía,
 * esta continuará vacía.
 */
public class CompararCadenasConBackspaces {

    public static void main(String[] args) {

        final String text1 = "ab#c";
        final String text2 = "abc";

        System.out.printf("Strings %s and %s are equals: %b\n", text1, text2, compareStrings(text1, text2));
    }

    private static boolean compareStrings(final String text1, final String text2) {
        final Stack<Character> stack1, stack2;

        stack1 = stringToCharStackWithBackSpaces(text1);

        stack2 = stringToCharStackWithBackSpaces(text2);

        return stack1.equals(stack2);
    }

    private static Stack<Character> stringToCharStackWithBackSpaces(final String text1) {
        final Stack<Character> stack = new Stack<>();

        for(char c : text1.toCharArray()){
            if(c == '#'){
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack;
    }
}
