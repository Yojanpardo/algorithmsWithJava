package dev.yojanpardo;

public class AlienDictionary {

    public static void main(String[] args) {
        String humanAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String alienAlphabet = "yhesocvxduiglbkrztnwjpfmaq";

        String[] words = {"habito", "hacer", "lectura", "sonreir"};

        System.out.println("validating words with human alphabet");
        System.out.println(validateWordsWithAlphabet(words, humanAlphabet));
        System.out.println("validating words with alien alphabet");
        System.out.println(validateWordsWithAlphabet(words, alienAlphabet));
    }

    private static boolean validateWordsWithAlphabet(String[] words, String alphabet) {
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean isEquals = true;
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char letter1 = word1.charAt(j);
                char letter2 = word2.charAt(j);
                int index1 = alphabet.indexOf(letter1);
                int index2 = alphabet.indexOf(letter2);
                if(index1 > index2) {
                    return false;
                } else if(index1 < index2) {
                    isEquals = false;
                    break;
                }
            }

            if(isEquals && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}
