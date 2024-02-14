package dev.yojanpardo.grafosarboles.backtracking;

import static dev.yojanpardo.Helper.scanner;

public class WordSearch {

    private static final int[][] DIRECTIONS = new int[][] {{1,0},{-1, 0}, {0,1}, {0,-1}};
    public static void main(String[] args) {
        final String[][] matrix = buildMatrix();
        System.out.println("Insert the word you wanna find:");
        String word = scanner.nextLine();

        System.out.printf("Word [%s] is in matrix?: [%b]", word, isWordInMatrix(word, matrix));
    }

    private static boolean isWordInMatrix(String word, String[][] matrix) {

        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                if(word.startsWith(matrix[x][y])){
                    return dfs(word, matrix, x, y, "", x, y,0).equals(word);
                }
            }
        }
        
        return false;
    }

    private static String dfs(String word, String[][] matrix, int x, int y, String actualWord, int prevX, int prevY, int index) {
        if(word.equals(actualWord)) return actualWord;
        if(x < 0 || x >= matrix.length
                || y < 0 || y >= matrix[x].length
                || actualWord.length() >= word.length()
                || !String.valueOf(word.charAt(index)).equals(matrix[x][y])
        ) return "";

        for(int[] direction : DIRECTIONS){
            String newWord = "";
            int newX = x + direction[0], newY = y + direction[1];
            if(!(newX == prevX && newY == prevY))
                newWord = dfs(word, matrix, newX, newY, actualWord + matrix[x][y], x, y, index+1);
            if (newWord.equals(word)){
                return word;
            }
        }

        return "";
    }

    private static String[][] buildMatrix() {
        return new String[][] {
                {"H","O","P","N"},
                {"W","L","H","Z"},
                {"Q","A","Y","L"},
                {"T","S","P","X"},
        };
    }
}
