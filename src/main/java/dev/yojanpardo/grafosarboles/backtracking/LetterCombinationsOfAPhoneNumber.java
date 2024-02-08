package dev.yojanpardo.grafosarboles.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static dev.yojanpardo.Helper.scanner;

/**
 * a phone number is given and based on the letters in the phone keyboard
 * you need to determine the possible letters combinations
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * the keyboard
     */
    private static final Map<Character, char[]> NUMBERS_LETTERS = Map.of(
            '2', new char[]{'A', 'B', 'C'},
            '3', new char[]{'D', 'E', 'F'},
            '4', new char[]{'G', 'H', 'I'},
            '5', new char[]{'J', 'K', 'L'},
            '6', new char[]{'M', 'N', 'O'},
            '7', new char[]{'P', 'Q', 'R', 'S'},
            '8', new char[]{'T', 'U', 'V'},
            '9', new char[]{'W', 'X', 'Y', 'Z'}
    );

    /**
     * main method
     * @param args the args
     */
    public static void main(String[] args) {
        System.out.println("insert the number");
        String phoneNumber = scanner.nextLine();
        System.out.printf("posible combinations for phone number %s are:\n", phoneNumber);
        List<String> palabras = new ArrayList<>();
        getLetterCombinationsForPhoneNumber(0, phoneNumber, "", palabras);

        palabras.forEach(System.out::println);
    }

    /**
     *
     * @param index this is a recursive funcion so this index is used as iterator
     * @param phoneNumber the given phone number
     * @param palabraActual used to concat the letters on each recursion
     * @param palabras a string list where we add the words
     */
    private static void getLetterCombinationsForPhoneNumber(int index, String phoneNumber, String palabraActual, List<String> palabras){

        /*
         * the return condition is triggered when the index is equals to the phone number length
         */
        if(index == phoneNumber.length()){
            if (!palabraActual.isEmpty()){
                palabras.add(palabraActual);
            }
            return;
        }

        for(char letra : NUMBERS_LETTERS.get(phoneNumber.charAt(index))){
            getLetterCombinationsForPhoneNumber(index + 1, phoneNumber, palabraActual + letra, palabras);
        }
    }

}
